package spring.dto;

public class CarDto {
	
	private boolean isDeleted;
	private CarCriteria carCriteria;
	
	public CarDto() {
		this.isDeleted = false;
		this.carCriteria = new CarCriteria();
	}
	
	public CarDto(boolean isDeleted, CarCriteria carCriteria) {
		this.isDeleted = isDeleted;
		this.carCriteria = carCriteria;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public CarCriteria getCarCriteria() {
		return carCriteria;
	}

	public void setCarCriteria(CarCriteria carCriteria) {
		this.carCriteria = carCriteria;
	}

	@Override
	public String toString() {
		return "CarDto [isDeleted=" + isDeleted + ", carCriteria=" + carCriteria + "]";
	}
	
}
