package spring.daoi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.models.User;

@Repository
public interface UserDaoI extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
