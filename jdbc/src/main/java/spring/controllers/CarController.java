package spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.AddCarDto;
import spring.dto.CarDto;
import spring.dto.CarResponse;
import spring.dto.NotValidError;
import spring.models.Car;
import spring.service.CarService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/car")
public class CarController {

	private CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}

    @PostMapping("/all")
	public CarResponse getCars(@RequestBody CarDto carDto) {
    	System.out.println(carDto);
		return this.carService.findAll(carDto);
	}

    @GetMapping("/{id}")
	public Car getCar(@PathVariable long id) {
		return this.carService.findById(id);
	}

    @GetMapping("/mycars/{username}")
	public List<Car> getMyCars(@PathVariable String username) {
		return this.carService.findByUsername(username);
	}

    @PostMapping("/update")
	public void update(@Valid @RequestBody Car car) {
		this.carService.update(car);
	}

    @DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		this.carService.delete(id);
	}

    @PostMapping("/add")
	public void add(@Valid @RequestBody AddCarDto car) {
		this.carService.save(car);
	}
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<NotValidError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    	List<NotValidError> notValidErrors = new ArrayList<>();
		for(FieldError fieldError: e.getFieldErrors()) {
			notValidErrors.add(new NotValidError(fieldError.getField(), fieldError.getDefaultMessage()));
		}
    	return notValidErrors;
    }
}
