package k2021.Autovuokraus.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RentalContract {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date rentStart, rentEnd;

	private double rentprice;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rentalcontract")
	private List<Car> cars;

	public RentalContract() {
		super();
	}

	public RentalContract(Date rentStart, Date rentEnd, double rentprice, List<Car> cars) {
		super();
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.rentprice = rentprice;
		this.cars = cars;
	}

	public RentalContract(Date rentStart, Date rentEnd, double rentprice) {
		super();
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.rentprice = rentprice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRentStart() {
		return rentStart;
	}

	public void setRentStart(Date rentStart) {
		this.rentStart = rentStart;
	}

	public Date getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(Date rentEnd) {
		this.rentEnd = rentEnd;
	}

	public double getRentprice() {
		return rentprice;
	}

	public void setRentprice(double rentprice) {
		this.rentprice = rentprice;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "RentalContract [rentStart=" + rentStart + ", rentEnd=" + rentEnd + ", rentprice=" + rentprice
				+ ", cars=" + cars + "]";
	}



}
