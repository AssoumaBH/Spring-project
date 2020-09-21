package auth.example.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import auth.example.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findById(int id);

	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findByUsername(@Param("username") String username);
}
