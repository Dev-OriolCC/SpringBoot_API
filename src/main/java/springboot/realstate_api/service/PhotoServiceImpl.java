package springboot.realstate_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.mapper;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;
import springboot.realstate_api.model.Photo;
import springboot.realstate_api.model.Property;
import springboot.realstate_api.repository.PhotoRepository;
import springboot.realstate_api.repository.PropertyRepository;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository, PropertyRepository propertyRepository) {
        this.photoRepository = photoRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<PhotoRequestDto> getPropertyPhotos(String propertyId) {
        List<Photo> photoList = photoRepository.findAllByPropertiesEquals(propertyId);
        return mapper.photoToPhotoRequestDtos(photoList);
    }

    @Override
    public PhotoRequestDto addPhotoToProperty(PhotoRequestDto photoRequestDto) {
        Photo photo = new Photo();
        //Set<Property> propertySet = propertyRepository.findAllById(propertyId);
        photo.setId(UUID.randomUUID().toString());
        photo.setUrl(photoRequestDto.getUrl());
        photo.setAlt(photoRequestDto.getAlt());
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
