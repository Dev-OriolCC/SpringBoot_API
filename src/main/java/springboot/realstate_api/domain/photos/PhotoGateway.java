package springboot.realstate_api.domain.photos;

import springboot.realstate_api.web.dto.requestDto.PhotoRequestDto;

import java.util.List;

public interface PhotoGateway {

    public List<PhotoRequestDto> getPropertyPhotos(String propertyId);
    public PhotoRequestDto addPhotoToProperty(Photo photo);
    public PhotoRequestDto deletePhotoFromProperty(String photoId);

}
