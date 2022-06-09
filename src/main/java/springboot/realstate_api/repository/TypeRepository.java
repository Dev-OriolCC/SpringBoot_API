package springboot.realstate_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, String> {

}
