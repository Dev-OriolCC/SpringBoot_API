package springboot.realstate_api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.data.entities.PhotoEntity;
import springboot.realstate_api.data.entities.PropertyEntity;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, String> {
    PropertyEntity findByPhotos(PhotoEntity photo);
    Integer countByTypeId(String id);
}
