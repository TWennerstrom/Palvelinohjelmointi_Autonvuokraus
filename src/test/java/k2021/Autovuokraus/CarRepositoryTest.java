package k2021.Autovuokraus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import k2021.Autovuokraus.domain.Car;
import k2021.Autovuokraus.domain.CarModelRepository;
import k2021.Autovuokraus.domain.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	
	@Autowired
	CarRepository carRepository;
	@Autowired
	CarModelRepository carModelRepository;
	
	@Test
	public void findByReknroCarShouldReturnListOfCars() {
		List<Car> cars = carRepository.findByReknro("RNA-774");
		assertThat(cars).hasSize(1);
		assertThat(cars.get(0).getYear() == 2018);
	}

}
