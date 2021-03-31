package k2021.Autovuokraus.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k2021.Autovuokraus.domain.Car;
import k2021.Autovuokraus.domain.CarModel;
import k2021.Autovuokraus.domain.CarModelRepository;
import k2021.Autovuokraus.domain.CarRepository;

@Controller
public class CarController {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CarModelRepository carModelRepository;

	@RequestMapping(value = { "/", "/home" })
	public String carList() {
		return "home";
	}

	@RequestMapping(value = { "/carlist" })
	public String carList(Model model) {
		model.addAttribute("cars", carRepository.findAll());
		return "carlist";
	}

	@GetMapping("add")
	public String addCar(Car car, Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("carmodels", carModelRepository.findAll());
		return "addcar";
	}
	
	@GetMapping("addcarmodel")
	public String addCarModel(CarModel carModel, Model model) {
		model.addAttribute("carmodel", new CarModel());
		return "addcarmodel";
	}

	@PostMapping("save")
	public String saveCar(@Valid Car car, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("carmodels", carModelRepository.findAll());
			return "addcar";
		}
		carRepository.save(car);
		return "redirect:/carlist";
	}
	
	@PostMapping("savemodel")
	public String saveCarModel(@Valid CarModel carModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "addcarmodel";
		}
		carModelRepository.save(carModel);
		return "redirect:/carlist";
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCar(@PathVariable("id") Long carId, Model model) {
		carRepository.deleteById(carId);
		return "redirect:/carlist";
	}

	@GetMapping("/edit/{id}")
	public String updateCar(@PathVariable("id") Long carId, Model model) {
		Car car = carRepository.findById(carId).get();
		model.addAttribute("car", car);
		model.addAttribute("carmodels", carModelRepository.findAll());
		return "editCar";
	}
}
