package springboot.realstate_api.domain.photos;

import springboot.realstate_api.web.dto.PhotoDto;

import java.util.List;

public interface PhotoGateway {

    public List<Photo> getPropertyPhotos(String propertyId);
    public Photo addPhotoToProperty(Photo photo);
    public Photo deletePhotoFromProperty(String photoId);

}
