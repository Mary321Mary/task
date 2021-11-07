package spring.dto;

public class CarDto {
	
	private boolean isDeleted;
	private int page;
	private CarCriteria carCriteria;
	
	public CarDto() {
		this.isDeleted = false;
		this.page = 0;
		this.carCriteria = new CarCriteria();
	}
	
	public CarDto(boolean isDeleted, int page, CarCriteria carCriteria) {
		this.isDeleted = isDeleted;
		this.page = page;
		this.carCriteria = carCriteria;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public CarCriteria getCarCriteria() {
		return carCriteria;
	}

	public void setCarCriteria(CarCriteria carCriteria) {
		this.carCriteria = carCriteria;
	}

	@Override
	public String toString() {
		return "CarDto [isDeleted=" + isDeleted + ", page=" + page + ", carCriteria=" + carCriteria + "]";
	}
	
}
