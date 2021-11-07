package spring.dto;

public class CarCriteria {
	
	private String model;
	private String generation;
	private String mileage;
	private String engine;
	private double priceFrom;
	private double priceTo;
	private String sort;
	
	public CarCriteria() {
		this.model = "";
		this.generation = "";
		this.mileage = "";
		this.engine = "";
		this.priceFrom = 0;
		this.priceTo = 50000;
		this.sort = "Acs";
	}
	
	public CarCriteria(String model, String generation, String mileage, String engine, double priceFrom,
			double priceTo, String sort) {
		this.model = model;
		this.generation = generation;
		this.mileage = mileage;
		this.engine = engine;
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
		this.sort = sort;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public double getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(double priceFrom) {
		this.priceFrom = priceFrom;
	}

	public double getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(double priceTo) {
		this.priceTo = priceTo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "CarCriteria [model=" + model + ", generation=" + generation + ", mileage=" + mileage + ", engine="
				+ engine + ", priceFrom=" + priceFrom + ", priceTo=" + priceTo + ", sort=" + sort + "]";
	}
	
}
