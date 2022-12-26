package springboot.realstate_api.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
