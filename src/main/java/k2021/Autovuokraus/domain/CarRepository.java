package k2021.Autovuokraus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	List<Car> findByReknro(String reknro);

}
