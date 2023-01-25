package springboot.realstate_api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.data.entities.TypeEntity;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, String> {

}
