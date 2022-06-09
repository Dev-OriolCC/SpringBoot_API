package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;

import java.util.List;

@Service
public interface PhotoService {

    public List<PhotoRequestDto> getPropertyPhotos(String propertyId);
    public PhotoRequestDto addPhotoToProperty(PhotoRequestDto photoRequestDto);
    public PhotoRequestDto deletePhotoFromProperty(String photoId); // From property

//    public PhotoRequestDto addPhotoToUser(PhotoRequestDto photoRequestDto);
    // Delete from User


}
