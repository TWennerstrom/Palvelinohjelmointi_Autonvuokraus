package k2021.Autovuokraus.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RentalContractRepository extends CrudRepository<RentalContract, Long> {

	List<RentalContract> findByRentStart(Date rentstart);
}
