package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.PhotoEntity;
import springboot.realstate_api.data.repositories.PhotoRepository;
import springboot.realstate_api.domain.photos.Photo;
import springboot.realstate_api.domain.photos.PhotoGateway;
import springboot.realstate_api.web.dto.PhotoDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultPhotoGateway implements PhotoGateway {
    private final PhotoRepository photoRepository;

    @Override
    public List<Photo> getPropertyPhotos(String propertyId) {
        List<PhotoEntity> photoEntities = photoRepository.findPhotosByPropertiesIs(propertyId);
        return photoEntities.stream().map(this::toModel).collect(toList());
    }

    @Override
    public Photo addPhotoToProperty(Photo photo) {
        return toModel(photoRepository.save(toEntity(photo)));
    }

    @Override
    public Photo deletePhotoFromProperty(String photoId) {
        PhotoEntity photoEntity = photoRepository.findById(photoId).orElseThrow(() -> new RuntimeException("Error!"));
        photoRepository.delete(photoEntity);
        return toModel(photoEntity);
    }


    //Builder methods
    private Photo toModel(PhotoEntity photoEntity) {
        return Photo.builder()
                .id(photoEntity.getId())
                .name(photoEntity.getName())
                .url(photoEntity.getUrl())
                .size(photoEntity.getSize())
                .fileType(photoEntity.getFileType())
                .createdAt(photoEntity.getCreatedAt())
                .updatedAt(photoEntity.getUpdatedAt())
                .deleted(photoEntity.isDeleted())
                .build();
    }

    private PhotoEntity toEntity(Photo photo) {
        return PhotoEntity.builder()
                .id(photo.getId())
                .name(photo.getName())
                .url(photo.getUrl())
                .size(photo.getSize())
                .fileType(photo.getFileType())
                .createdAt(photo.getCreatedAt())
                .updatedAt(photo.getUpdatedAt())
                .deleted(photo.isDeleted())
                .build();
    }

}
