package k2021.Autovuokraus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import k2021.Autovuokraus.domain.Car;
import k2021.Autovuokraus.domain.CarModel;
import k2021.Autovuokraus.domain.CarModelRepository;
import k2021.Autovuokraus.domain.CarRepository;

@RestController
public class RestCarController {
	
	@Autowired
	private CarRepository cRepository;
	@Autowired
	private CarModelRepository cMRepository;
	
	@RequestMapping("/cars")
	public List <Car>carListRest() {
		return (List<Car>) cRepository.findAll();
	}
	
	@RequestMapping("/carmodels")
	public List <CarModel> carModelListRest() {
		return (List<CarModel>) cMRepository.findAll();
	}

}
