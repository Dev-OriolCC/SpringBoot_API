package springboot.realstate_api.domain.properties;

import org.springframework.stereotype.Service;
import springboot.realstate_api.web.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.web.dto.responseDto.PropertyResponseDto;

import java.util.List;

public interface PropertyGateway {
    public List<PropertyResponseDto> getProperties();
    public PropertyResponseDto addProperty(Property property);
    public PropertyResponseDto deleteProperty(String propertyId);
    public PropertyResponseDto editProperty(PropertyRequestDto propertyRequestDto, String propertyId);
    // Relational
    public PropertyResponseDto updateTypeFromProperty(String typeId, String propertyId);
    public PropertyResponseDto updateLocationFromProperty(String locationId, String propertyId);

    public PropertyResponseDto addFeatureToProperty(String featureId, String propertyId);
    public PropertyResponseDto deleteFeatureFromProperty(String featureId, String propertyId);


}
