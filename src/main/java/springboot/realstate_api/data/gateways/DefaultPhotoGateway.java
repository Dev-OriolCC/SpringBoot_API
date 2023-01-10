package springboot.realstate_api.data.gateways;

import springboot.realstate_api.domain.photos.Photo;
import springboot.realstate_api.domain.photos.PhotoGateway;
import springboot.realstate_api.web.dto.requestDto.PhotoRequestDto;

import java.util.List;

public class DefaultPhotoGateway implements PhotoGateway {
    @Override
    public List<PhotoRequestDto> getPropertyPhotos(String propertyId) {
        return null;
    }

    @Override
    public PhotoRequestDto addPhotoToProperty(Photo photo) {
        return null;
    }

    @Override
    public PhotoRequestDto deletePhotoFromProperty(String photoId) {
        return null;
    }
}
