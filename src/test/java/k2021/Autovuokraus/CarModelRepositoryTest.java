package k2021.Autovuokraus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import k2021.Autovuokraus.domain.CarModel;
import k2021.Autovuokraus.domain.CarModelRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarModelRepositoryTest {
	
	@Autowired
	CarModelRepository carModelRepository;
	
	@Test
	public void findByModelShouldReturnCarModelId() {
		List<CarModel> carmodels = carModelRepository.findByModel("Transit");
		assertThat(carmodels.get(0).getId()).isEqualTo(1);
	}
	
	@Test
	public void createNewCarModel() {
		CarModel carmodel = new CarModel("TestiMalli", "TestiMerkki");
		carModelRepository.save(carmodel);
		assertThat(carmodel.getId()).isNotNull();
	}

}
