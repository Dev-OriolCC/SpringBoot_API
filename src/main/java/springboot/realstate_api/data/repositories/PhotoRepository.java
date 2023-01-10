package springboot.realstate_api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.data.entities.Photo;
import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
    List<Photo> findPhotosByPropertiesIs(String properties);
    List<Photo> findAllByProperties(String propertyId);
}
