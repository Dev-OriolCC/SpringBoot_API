package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;

import java.util.List;

@Service
public interface PropertyService {
    public List<PropertyResponseDto> getProperties();
    public PropertyResponseDto addProperty(PropertyRequestDto propertyRequestDto);
    public PropertyResponseDto deleteProperty(String propertyId);
    public PropertyResponseDto editProperty(PropertyRequestDto propertyRequestDto, String propertyId);
    // Relational
    public PropertyResponseDto updateTypeFromProperty(String typeId, String propertyId);
    public PropertyResponseDto updateLocationFromProperty(String locationId, String propertyId);

    public PropertyResponseDto addFeatureToProperty(String featureId, String propertyId);
    public PropertyResponseDto deleteFeatureFromProperty(String featureId, String propertyId);


}
