package k2021.Autovuokraus.domain;

import org.springframework.data.repository.CrudRepository;

import k2021.Autovuokraus.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUsername(String username);

}
