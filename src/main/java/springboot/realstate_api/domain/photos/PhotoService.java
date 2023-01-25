package springboot.realstate_api.domain.photos;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.realstate_api.data.gateways.DefaultPhotoGateway;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PhotoService {

    private final DefaultPhotoGateway defaultPhotoGateway;

    public List<Photo> getPropertyPhotos(String propertyId) {
        return defaultPhotoGateway.getPropertyPhotos(propertyId);
    }

    public Photo addPhotoToProperty(Photo photo) {
        return defaultPhotoGateway.addPhotoToProperty(photo);
    }

    public Photo deletePhotoFromProperty(String photoId) {
        return defaultPhotoGateway.deletePhotoFromProperty(photoId);
    }


    /*
    private final PhotoRepository photoRepository;
    private final PropertyRepository propertyRepository;
    @Autowired
    public PhotoService(PhotoRepository photoRepository, PropertyRepository propertyRepository) {
        this.photoRepository = photoRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<PhotoDto> getPropertyPhotos(String propertyId) {
        PropertyEntity property = propertyRepository.findById(propertyId).get();
        List<PhotoEntity> photoList = property.getPhotos().stream().toList();

        return mapper.photoToPhotoRequestDtos(photoList);
    }

    @Override
    public PhotoDto addPhotoToProperty(springboot.realstate_api.domain.photos.Photo photo) {
        return null;
    }

    @Override
    public PhotoDto addPhotoToProperty(PhotoDto photoRequestDto) {
        PhotoEntity photo = new PhotoEntity();
        //Set<Property> propertySet = propertyRepository.findAllById(propertyId);
        photo.setId(UUID.randomUUID().toString());
        photo.setUrl(photoRequestDto.getUrl());
        photo.setName(photoRequestDto.getName());
        photo.setSize(photoRequestDto.getSize());
        photo.setFileType(photoRequestDto.getFileType());
        PropertyEntity property = propertyRepository.findById(photoRequestDto.getPropertyId()).get();

        property.getPhotos().add(photo); // [Test]
        photoRepository.save(photo);
        return mapper.photoToPhotoRequestDto(photo);
    }

    @Override
    public PhotoDto deletePhotoFromProperty(String photoId) {
        PhotoEntity photo = getPhotoMethod(photoId);
        PropertyEntity property = propertyRepository.findByPhotos(photo);
        // Remove relation
        property.getPhotos().remove(photo);
        // Delete actual photo
        propertyRepository.save(property);
        photoRepository.delete(photo);
        return mapper.photoToPhotoRequestDto(photo);
    }

    // Service internal methods
    public PhotoEntity getPhotoMethod(String photoId) {
        return photoRepository.findById(photoId).orElseThrow(() ->
                new IllegalArgumentException("Photo not found: "+photoId));
    }
     */
}
