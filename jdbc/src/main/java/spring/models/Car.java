package spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "UPDATE Car SET deleted = true WHERE id=?")
@FilterDefs({
	@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean")),
	@FilterDef(name = "carDeletedFilter", parameters = {@ParamDef(name = "isDeleted", type = "boolean"),
			@ParamDef(name = "model", type = "string"), @ParamDef(name = "generation", type = "string"),
			@ParamDef(name = "mileage", type = "string"), @ParamDef(name = "engine", type = "string"),
			@ParamDef(name = "priceFrom", type = "double"), @ParamDef(name = "priceTo", type = "double")
	}),
	@FilterDef(name = "carFilter", parameters = {
			@ParamDef(name = "model", type = "string"), @ParamDef(name = "generation", type = "string"),
			@ParamDef(name = "mileage", type = "string"), @ParamDef(name = "engine", type = "string"),
			@ParamDef(name = "priceFrom", type = "double"), @ParamDef(name = "priceTo", type = "double")
	})
})
@Filters({
	@Filter(name = "deletedFilter", condition = "deleted = :isDeleted"),
	@Filter(name = "carDeletedFilter", condition = "deleted = :isDeleted and model like :model and "
			+ "generation like :generation and mileage like :mileage and engine like :engine and "
			+ "price between :priceFrom and :priceTo"),
	@Filter(name = "carFilter", condition = "model like :model and generation like :generation and " + 
		"mileage like :mileage and engine like :engine and price between :priceFrom and :priceTo")
})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	private String name;
	private String model;
	private String generation;
	private String mileage;
	private String engine;

	@NotNull
	private double price;

    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    private User user;

	public Car() {
		this.id = (long) -1;
		this.name = "";
		this.model = "";
		this.generation = "";
		this.mileage = "";
		this.engine = "";
		this.price = 0;
	}

	public Car(Long id, String name, String model, String generation, String mileage, String engine, double price, User user) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.generation = generation;
		this.mileage = mileage;
		this.engine = engine;
		this.price = price;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", model=" + model + ", generation=" + generation + ", mileage="
				+ mileage + ", engine=" + engine + ", price=" + price + "]";
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
