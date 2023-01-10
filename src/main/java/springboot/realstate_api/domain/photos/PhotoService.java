package springboot.realstate_api.domain.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.web.dto.mapper;
import springboot.realstate_api.web.dto.requestDto.PhotoRequestDto;
import springboot.realstate_api.data.entities.Photo;
import springboot.realstate_api.data.entities.Property;
import springboot.realstate_api.data.repositories.PhotoRepository;
import springboot.realstate_api.data.repositories.PropertyRepository;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoService implements PhotoGateway {

    private final PhotoRepository photoRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository, PropertyRepository propertyRepository) {
        this.photoRepository = photoRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<PhotoRequestDto> getPropertyPhotos(String propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
        List<Photo> photoList = property.getPhotos().stream().toList();

        return mapper.photoToPhotoRequestDtos(photoList);
    }

    @Override
    public PhotoRequestDto addPhotoToProperty(springboot.realstate_api.domain.photos.Photo photo) {
        return null;
    }

    @Override
    public PhotoRequestDto addPhotoToProperty(PhotoRequestDto photoRequestDto) {
        Photo photo = new Photo();
        //Set<Property> propertySet = propertyRepository.findAllById(propertyId);
        photo.setId(UUID.randomUUID().toString());
        photo.setUrl(photoRequestDto.getUrl());
        photo.setName(photoRequestDto.getName());
        photo.setSize(photoRequestDto.getSize());
        photo.setFileType(photoRequestDto.getFileType());
        Property property = propertyRepository.findById(photoRequestDto.getPropertyId()).get();

        property.getPhotos().add(photo); // [Test]
        photoRepository.save(photo);
        return mapper.photoToPhotoRequestDto(photo);
    }

    @Override
    public PhotoRequestDto deletePhotoFromProperty(String photoId) {
        Photo photo = getPhotoMethod(photoId);
        Property property = propertyRepository.findByPhotos(photo);
        // Remove relation
        property.getPhotos().remove(photo);
        // Delete actual photo
        propertyRepository.save(property);
        photoRepository.delete(photo);
        return mapper.photoToPhotoRequestDto(photo);
    }

    // Service internal methods
    public Photo getPhotoMethod(String photoId) {
        return photoRepository.findById(photoId).orElseThrow(() ->
                new IllegalArgumentException("Photo not found: "+photoId));
    }
}
