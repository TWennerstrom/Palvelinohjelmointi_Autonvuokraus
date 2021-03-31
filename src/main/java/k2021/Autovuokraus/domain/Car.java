package k2021.Autovuokraus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min=3, max=10)
	private String reknro;

	@Min(1900)
	@Max(2021)
	private int year;

	@Min(1)
	private int readout;

	@Min(1)
	private double price;

	@ManyToOne
	@JoinColumn(name = "modelid")
	CarModel carmodel;
	
	@ManyToOne
	@JoinColumn(name = "rentalcontractid")
	RentalContract rentalcontract;

	public Car() {
		super();
	}

	public Car(String reknro, int year, int readout, double price, CarModel carmodel) {
		super();
		this.reknro = reknro;
		this.year = year;
		this.readout = readout;
		this.price = price;
		this.carmodel = carmodel;
	}

	public Car(String reknro, int year, int readout, double price) {
		super();
		this.reknro = reknro;
		this.year = year;
		this.readout = readout;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReknro() {
		return reknro;
	}

	public void setReknro(String reknro) {
		this.reknro = reknro;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getReadout() {
		return readout;
	}

	public void setReadout(int readout) {
		this.readout = readout;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CarModel getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(CarModel carmodel) {
		this.carmodel = carmodel;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", reknro=" + reknro + ", year=" + year + ", readout=" + readout + ", price=" + price
				+ ", carmodel=" + carmodel + "]";
	}

}
