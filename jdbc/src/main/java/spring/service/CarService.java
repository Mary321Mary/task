package spring.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.daoi.CarDaoI;
import spring.daoi.UserDaoI;
import spring.dto.AddCarDto;
import spring.dto.CarDto;
import spring.dto.CarResponse;
import spring.models.Car;
import spring.models.User;

@Service
@Transactional
public class CarService {
	
    private CarDaoI carDao;
    private UserDaoI userDao;
    private EntityManager entityManager;

	public CarService(CarDaoI carDao, UserDaoI userDao, EntityManager entityManager){
		this.carDao = carDao;
		this.userDao = userDao;
		this.entityManager = entityManager;
	}

    public CarResponse findAll(CarDto carDto) {
    	if("".equals(carDto.getCarCriteria().getModel())) {
    		carDto.getCarCriteria().setModel("%");
    	}
    	if("".equals(carDto.getCarCriteria().getGeneration())) {
    		carDto.getCarCriteria().setGeneration("%");
    	}
    	if("".equals(carDto.getCarCriteria().getMileage())) {
    		carDto.getCarCriteria().setMileage("%");
    	}
    	if("".equals(carDto.getCarCriteria().getEngine())) {
    		carDto.getCarCriteria().setEngine("%");
    	}
    	Direction sort;
    	if("Asc".equals(carDto.getCarCriteria().getSort())) {
    		sort = Sort.Direction.ASC;
    	} else {
    		sort = Sort.Direction.DESC;
    	}
    	Session session = entityManager.unwrap(Session.class);
    	List<Car> cars;
    	int totalPages;
    	if(carDto.getIsDeleted() == true) {
            Filter filter = session.enableFilter("carFilter");
            filter.setParameter("model", carDto.getCarCriteria().getModel());
            filter.setParameter("generation", carDto.getCarCriteria().getGeneration());
            filter.setParameter("mileage", carDto.getCarCriteria().getMileage());
            filter.setParameter("engine", carDto.getCarCriteria().getEngine());
            filter.setParameter("priceFrom", carDto.getCarCriteria().getPriceFrom());
            filter.setParameter("priceTo", carDto.getCarCriteria().getPriceTo());
            Page<Car> carsPages = this.carDao.findAll(PageRequest.of( carDto.getPage(), 5, sort, "price" ));
            cars = carsPages.getContent();
            totalPages = carsPages.getTotalPages();
            session.disableFilter("carFilter");
    	} else {
            Filter filter = session.enableFilter("carDeletedFilter");
            filter.setParameter("isDeleted", carDto.getIsDeleted());
            filter.setParameter("model", carDto.getCarCriteria().getModel());
            filter.setParameter("generation", carDto.getCarCriteria().getGeneration());
            filter.setParameter("mileage", carDto.getCarCriteria().getMileage());
            filter.setParameter("engine", carDto.getCarCriteria().getEngine());
            filter.setParameter("priceFrom", carDto.getCarCriteria().getPriceFrom());
            filter.setParameter("priceTo", carDto.getCarCriteria().getPriceTo());
            Page<Car> carsPages = this.carDao.findAll(PageRequest.of( carDto.getPage(), 5, sort, "price" ));
            cars = carsPages.getContent();
            totalPages = carsPages.getTotalPages();
            session.disableFilter("carDeletedFilter");
    	}
    	System.out.println(cars);
    	List<String> carsModels = this.carDao.findAllModels();
    	List<String> carsGenerations = this.carDao.findAllGenerations();
    	List<String> carsMileages = this.carDao.findAllMileages();
    	List<String> carsEngines = this.carDao.findAllEngines();
    	carsModels.add("");
    	carsGenerations.add("");
    	carsMileages.add("");
    	carsEngines.add("");
        return new CarResponse(cars, carsModels, carsGenerations, carsMileages, carsEngines, totalPages);
    }

    public Car findById(long id) {
    	if(id != -1){
            return carDao.findById(id).get();
    	} else {
    		return new Car();
    	}
    }

    public List<Car> findByUsername(String username) {
    	Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", false);
		User user = this.userDao.findByUsername(username).get();
		List<Car> cars = carDao.findByUser(user);  
        session.disableFilter("deletedFilter");
        return cars;
    }

	public void update(Car car) {
		Car carForUpdate = this.carDao.getOne(car.getId());
		carForUpdate.setName(car.getName());
        carForUpdate.setModel(car.getModel());
        carForUpdate.setGeneration(car.getGeneration());
        carForUpdate.setMileage(car.getMileage());
        carForUpdate.setEngine(car.getEngine());
        carForUpdate.setPrice(car.getPrice());
        this.carDao.saveAndFlush(carForUpdate);
	}

	public void delete(long id) {
		this.carDao.deleteById(id);
	}

	public void save(AddCarDto car) {
		User user = this.userDao.findByUsername(car.getUsername()).get();
		car.getCar().setUser(user);
        this.carDao.saveAndFlush(car.getCar());
	}

}
