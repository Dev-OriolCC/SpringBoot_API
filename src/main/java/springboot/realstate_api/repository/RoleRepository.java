package springboot.realstate_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
