package springboot.realstate_api.data.gateways;

import springboot.realstate_api.domain.properties.Property;
import springboot.realstate_api.domain.properties.PropertyGateway;
import springboot.realstate_api.web.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.web.dto.responseDto.PropertyResponseDto;

import java.util.List;

public class DefaultPropertyGateway implements PropertyGateway {
    @Override
    public List<PropertyResponseDto> getProperties() {
        return null;
    }

    @Override
    public PropertyResponseDto addProperty(Property property) {
        return null;
    }

    @Override
    public PropertyResponseDto deleteProperty(String propertyId) {
        return null;
    }

    @Override
    public PropertyResponseDto editProperty(PropertyRequestDto propertyRequestDto, String propertyId) {
        return null;
    }

    @Override
    public PropertyResponseDto updateTypeFromProperty(String typeId, String propertyId) {
        return null;
    }

    @Override
    public PropertyResponseDto updateLocationFromProperty(String locationId, String propertyId) {
        return null;
    }

    @Override
    public PropertyResponseDto addFeatureToProperty(String featureId, String propertyId) {
        return null;
    }

    @Override
    public PropertyResponseDto deleteFeatureFromProperty(String featureId, String propertyId) {
        return null;
    }
}
