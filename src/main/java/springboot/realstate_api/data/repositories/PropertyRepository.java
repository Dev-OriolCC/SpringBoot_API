package springboot.realstate_api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.realstate_api.data.entities.Photo;
import springboot.realstate_api.data.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {
    Property findByPhotos(Photo photo);
}
