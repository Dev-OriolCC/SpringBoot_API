package springboot.realstate_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.model.Photo;
import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {

    List<Photo> findAllByPropertiesEquals(String properties);
    List<Photo> findAllByProperties(String propertyId);
}
