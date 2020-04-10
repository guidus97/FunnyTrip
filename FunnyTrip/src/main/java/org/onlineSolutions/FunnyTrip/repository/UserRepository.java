package org.onlineSolutions.FunnyTrip.repository;

import java.util.Optional;

import org.onlineSolutions.FunnyTrip.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
