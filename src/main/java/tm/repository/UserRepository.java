package tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tm.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
