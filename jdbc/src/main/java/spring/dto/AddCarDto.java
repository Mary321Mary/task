package spring.dto;

import javax.validation.Valid;

import spring.models.Car;

public class AddCarDto {
	
	@Valid
	private Car car;
	private String username;
	
	public AddCarDto() {
		this.car = new Car();
		this.username = "";
	}
	
	public AddCarDto(Car car, String username) {
		this.car = car;
		this.username = username;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AddCarDto [car=" + car + ", username=" + username + "]";
	}

}
