package spring.daoi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.models.Car;
import spring.models.User;

@Repository
public interface CarDaoI extends JpaRepository<Car, Long> {
	
	List<Car> findByUser(User user);
	
    @Query(value = "SELECT distinct model FROM car", nativeQuery = true)
	List<String> findAllModels();

    @Query(value = "SELECT distinct generation FROM car", nativeQuery = true)
	List<String> findAllGenerations();

    @Query(value = "SELECT distinct mileage FROM car", nativeQuery = true)
	List<String> findAllMileages();

    @Query(value = "SELECT distinct engine FROM car", nativeQuery = true)
	List<String> findAllEngines();

}
