package jp.ddo.chiroru.sample.integration;

import java.util.List;

import jp.ddo.chiroru.sample.domain.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SimpleUserRepository
		extends CrudRepository<User, Long> {

	User findByTheUsersName(String username);
	
	List<User> findByLastname(String lastname);
	
	@Query("select u from User u where u.firstname = ?")
	List<User> findByFirstname(String firstname);
	
	@Query("select u from User u where u.firstname = :name or u.lastname = :name")
	List<User> findByFirstnameOrLastname(@Param("name") String name);
}
