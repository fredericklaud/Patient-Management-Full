package edu.secourse.patientportal.pmbackend.repository;

import edu.secourse.patientportal.pmbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /** Find user by username. */
    Optional<User> findByUsername(String username);

    /** Check to see if user already exists. */
    boolean existsByUsername(String username);

}
