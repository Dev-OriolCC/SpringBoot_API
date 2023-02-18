package springboot.realstate_api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
    Integer countUserEntitiesByRole(RoleEntity role); // testr
}
