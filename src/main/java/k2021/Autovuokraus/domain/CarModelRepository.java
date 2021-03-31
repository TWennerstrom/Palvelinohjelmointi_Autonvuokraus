package k2021.Autovuokraus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarModelRepository extends CrudRepository<CarModel, Long>{
	
	List<CarModel> findByModel(String model);
	List<CarModel> findByManufacturer(String manufacturer);

}
