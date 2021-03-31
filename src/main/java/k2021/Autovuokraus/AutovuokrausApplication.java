package k2021.Autovuokraus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k2021.Autovuokraus.domain.AppUser;
import k2021.Autovuokraus.domain.AppUserRepository;
import k2021.Autovuokraus.domain.Car;
import k2021.Autovuokraus.domain.CarModel;
import k2021.Autovuokraus.domain.CarModelRepository;
import k2021.Autovuokraus.domain.CarRepository;


@SpringBootApplication
public class AutovuokrausApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutovuokrausApplication.class, args);
	}

	@Bean
	public CommandLineRunner autoDemo(CarRepository cRepository, CarModelRepository cMRepository,
			AppUserRepository userRepository) {
		return (args) -> {
			
			System.out.println("Save car models");
			cMRepository.save(new CarModel("Transit", "Ford"));
			cMRepository.save(new CarModel("Sprinter", "Mercedes-Benz"));
			cMRepository.save(new CarModel("Boxer", "Peugeot"));
			cMRepository.save(new CarModel("NV300", "Nissan"));
			
			System.out.println("Save cars");
			cRepository.save(new Car("OUM-592", 2019, 139000, 15, 
					cMRepository.findByModel("Sprinter").get(0)));
			
			cRepository.save(new Car("RNA-774", 2018, 96000, 15, 
					cMRepository.findByModel("Transit").get(0)));
			
			cRepository.save(new Car("BOX-390", 2013, 292000, 10, 
					cMRepository.findByModel("Boxer").get(0)));
			
			cRepository.save(new Car("NIS-555", 2018, 96000, 10, 
					cMRepository.findByModel("NV300").get(0)));
			
			System.out.println("Fetch all car models");
			for (CarModel carmodel : cMRepository.findAll()) {
				System.out.println(carmodel.toString());
			}
			
			System.out.println("Fetch all cars");
			for (Car car : cRepository.findAll()) {
				System.out.println(car.toString());
			}
			
			AppUser user1 = new AppUser("user", "$2a$10$y.NgWtx7SlKaomvWKGKNEe9js4ELZhMKkIPpQWwG/0JUHtRlgJDoS", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$uJ.HaKB1.nUFZOwFw1bid.bT49J2ik/1pp1DWYiowEmu9jz0IR82S", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
		};
	}
	
}
