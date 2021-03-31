package k2021.Autovuokraus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k2021.Autovuokraus.domain.CarRepository;
import k2021.Autovuokraus.domain.RentalContract;
import k2021.Autovuokraus.domain.RentalContractRepository;

@Controller
public class RentController {
	@Autowired
	private RentalContractRepository rentRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping(value="/rent/{id}")
	public String rentCar(@PathVariable("id") Long carId, Model model) {
		model.addAttribute("car", carRepository.findById(carId));
		return "rentcar";
	}
	
	@PostMapping(value="/saverent")
	public String saveRent(RentalContract rentalContract) {
		rentRepository.save(rentalContract);
		return "redirect:/carlist";
	}
}	
