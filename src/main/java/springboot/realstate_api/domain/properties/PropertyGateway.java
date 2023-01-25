package springboot.realstate_api.domain.properties;

import springboot.realstate_api.web.dto.PropertyRequestDto;
import springboot.realstate_api.web.dto.PropertyResponseDto;

import java.util.List;

public interface PropertyGateway {
    public List<Property> getProperties();
    public Property create(Property property);
    public Property delete(String propertyId);
    public Property update(PropertyRequestDto propertyRequestDto, String propertyId);
    // Relational
    public Property updateTypeFromProperty(String typeId, String propertyId);
    public Property updateLocationFromProperty(String locationId, String propertyId);

    public Property addFeatureToProperty(String featureId, String propertyId);
    public Property deleteFeatureFromProperty(String featureId, String propertyId);


}
