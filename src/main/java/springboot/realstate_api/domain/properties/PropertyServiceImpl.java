package springboot.realstate_api.domain.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.auth.entity.User;
import springboot.realstate_api.auth.repository.UserRepository;
import springboot.realstate_api.data.entities.Feature;
import springboot.realstate_api.data.entities.Location;
import springboot.realstate_api.data.entities.Property;
import springboot.realstate_api.data.entities.Type;
import springboot.realstate_api.data.repositories.FeatureRepository;
import springboot.realstate_api.data.repositories.LocationRepository;
import springboot.realstate_api.data.repositories.PropertyRepository;
import springboot.realstate_api.data.repositories.TypeRepository;
import springboot.realstate_api.dto.mapper;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final TypeRepository typeRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, TypeRepository typeRepository, LocationRepository locationRepository, UserRepository userRepository, FeatureRepository featureRepository) {
        this.propertyRepository = propertyRepository;
        this.typeRepository = typeRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public List<PropertyResponseDto> getProperties() {
        List<Property> properties = propertyRepository.findAll();
        return mapper.propertyToPropertyResponseDtos(properties);
    }

    @Override
    public PropertyResponseDto addProperty(PropertyRequestDto propertyRequestDto) {
        Property property = new Property();
        property.setId(UUID.randomUUID().toString());
        property.setTitle(propertyRequestDto.getTitle());
        property.setPrice(propertyRequestDto.getPrice());
        property.setDescription(propertyRequestDto.getDescription());
        property.setDetails(propertyRequestDto.getDetails());
        property.setSquarefeet(propertyRequestDto.getSquarefeet());
        property.setBaths(propertyRequestDto.getBaths());
        property.setBeds(propertyRequestDto.getBeds());
        property.setState(propertyRequestDto.getState());
        property.setDate_published(propertyRequestDto.getDate_published());
        property.setYear_built(propertyRequestDto.getYear_built());
        // Relation Data
        // [ pending ]
        Type type = typeRepository.findById(propertyRequestDto.getPropertyTypeId()).get();
        if (type != null) {
            property.setType(type);
        }
        Location location = locationRepository.findById(propertyRequestDto.getPropertyLocationId()).get();
        if (location != null) {
            property.setLocation(location);
        }
        User user = userRepository.findById(propertyRequestDto.getPropertyUserId()).get();
        if (user != null) {
           property.setUser(user);
        }

        propertyRepository.save(property);
        return mapper.propertyToPropertyResponseDto(property);
    }

    @Override
    public PropertyResponseDto deleteProperty(String propertyId) {
        Property property = getPropertyMethod(propertyId);
        propertyRepository.delete(property);
        return mapper.propertyToPropertyResponseDto(property);
    }

    @Override
    public PropertyResponseDto editProperty(PropertyRequestDto propertyRequestDto, String propertyId) {
        Property propertyToEdit = getPropertyMethod(propertyId);
        //

        //
        propertyRepository.save(propertyToEdit);
        return mapper.propertyToPropertyResponseDto(propertyToEdit);
    }

    @Override
    public PropertyResponseDto updateTypeFromProperty(String typeId, String propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
        Type type = typeRepository.findById(typeId).get();
        if (property != null && type != null ) {
            property.setType(null);
            property.setType(type);
            propertyRepository.save(property);
            return mapper.propertyToPropertyResponseDto(property);
        }
        return null;
    }

    @Override
    public PropertyResponseDto updateLocationFromProperty(String locationId, String propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
        Location location = locationRepository.findById(locationId).get();
        if (property != null && location != null ) {
            property.setLocation(null);
            property.setLocation(location);
            propertyRepository.save(property);
            return mapper.propertyToPropertyResponseDto(property);
        }
        return null;
    }

    @Override
    public PropertyResponseDto addFeatureToProperty(String featureId, String propertyId) {
        Feature feature = featureRepository.findById(featureId).get();
        Property property = propertyRepository.findById(propertyId).get();
        if (feature != null && property != null) {
            property.getFeatures().add(feature);
            propertyRepository.save(property);
            return mapper.propertyToPropertyResponseDto(property);
        }
        return null;
    }

    @Override
    public PropertyResponseDto deleteFeatureFromProperty(String featureId, String propertyId) {
        Feature feature = featureRepository.findById(featureId).get();
        Property property = propertyRepository.findById(propertyId).get();
        if (feature != null && property != null) {
            property.getFeatures().remove(feature);
            propertyRepository.save(property);
            return mapper.propertyToPropertyResponseDto(property);
        }
        return null;
    }


    // Service internal methods
    public Property getPropertyMethod(String propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow(() ->
                new IllegalArgumentException("Property not found: "+propertyId));
    }
}
