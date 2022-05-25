package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.FeatureRequestDto;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;

import java.util.List;
import java.util.UUID;

@Service
public interface PhotoService {

    public List<PhotoRequestDto> getPropertyPhotos(UUID propertyId);
    public PhotoRequestDto addPhoto(PhotoRequestDto photoRequestDto);
    public PhotoRequestDto deletePhoto(UUID featureId);

}
