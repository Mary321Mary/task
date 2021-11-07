package spring.dto;

import java.util.ArrayList;
import java.util.List;

import spring.models.Car;

public class CarResponse {
	private List<Car> cars;
	private List<String> carsModels;
	private List<String> carsGenerations;
	private List<String> carsMileages;
	private List<String> carsEngines;
	
	public CarResponse() {
		this.cars = new ArrayList<>();
		this.carsModels = new ArrayList<>();
		this.carsGenerations = new ArrayList<>();
		this.carsMileages = new ArrayList<>();
		this.carsEngines = new ArrayList<>();
	}
	
	public CarResponse(List<Car> cars, List<String> carsModels, List<String> carsGenerations, List<String> carsMileages,
			List<String> carsEngines) {
		this.cars = cars;
		this.carsModels = carsModels;
		this.carsGenerations = carsGenerations;
		this.carsMileages = carsMileages;
		this.carsEngines = carsEngines;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<String> getCarsModels() {
		return carsModels;
	}

	public void setCarsModels(List<String> carsModels) {
		this.carsModels = carsModels;
	}

	public List<String> getCarsGenerations() {
		return carsGenerations;
	}

	public void setCarsGenerations(List<String> carsGenerations) {
		this.carsGenerations = carsGenerations;
	}

	public List<String> getCarsMileages() {
		return carsMileages;
	}

	public void setCarsMileages(List<String> carsMileages) {
		this.carsMileages = carsMileages;
	}

	public List<String> getCarsEngines() {
		return carsEngines;
	}

	public void setCarsEngines(List<String> carsEngines) {
		this.carsEngines = carsEngines;
	}

	@Override
	public String toString() {
		return "CarResponse [cars=" + cars + ", carsModels=" + carsModels + ", carsGenerations=" + carsGenerations
				+ ", carsMileages=" + carsMileages + ", carsEngines=" + carsEngines + "]";
	}
	
}
