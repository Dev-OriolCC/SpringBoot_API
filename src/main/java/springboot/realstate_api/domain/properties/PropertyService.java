package springboot.realstate_api.domain.properties;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.realstate_api.web.dto.PropertyRequestDto;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {

    private final PropertyGateway propertyGateway;
    public List<Property> getProperties() {
        return propertyGateway.getProperties();
    }

    public Property create(Property property) {
        return propertyGateway.create(property);
    }

    public Property delete(String propertyId) {
        return propertyGateway.delete(propertyId);
    }

    public Property update(PropertyRequestDto propertyRequestDto, String propertyId) {
        return propertyGateway.update(propertyRequestDto, propertyId);
    }

    public Property updateTypeFromProperty(String typeId, String propertyId) {
        return propertyGateway.updateTypeFromProperty(typeId, propertyId);
    }

    public Property updateLocationFromProperty(String locationId, String propertyId) {
        return propertyGateway.updateLocationFromProperty(locationId, propertyId);
    }

    public Property addFeatureToProperty(String featureId, String propertyId) {
        return propertyGateway.addFeatureToProperty(featureId, propertyId);
    }

    public Property deleteFeatureFromProperty(String featureId, String propertyId) {
        return propertyGateway.deleteFeatureFromProperty(featureId, propertyId);
    }

    /*

    private final PropertyRepository propertyRepository;
    private final TypeRepository typeRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository, TypeRepository typeRepository, LocationRepository locationRepository, UserRepository userRepository, FeatureRepository featureRepository) {
        this.propertyRepository = propertyRepository;
        this.typeRepository = typeRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public List<PropertyResponseDto> getProperties() {
        List<PropertyEntity> properties = propertyRepository.findAll();
        return mapper.propertyToPropertyResponseDtos(properties);
    }

    @Override
    public PropertyResponseDto addProperty(springboot.realstate_api.domain.properties.Property property) {
        return null;
    }

    @Override
    public PropertyResponseDto addProperty(PropertyRequestDto propertyRequestDto) {
        PropertyEntity property = new PropertyEntity();
        property.setId(UUID.randomUUID().toString());
        PropertyEntity property1 = PropertyEntity.builder().id(UUID.randomUUID().toString()).build();
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
        TypeEntity type = typeRepository.findById(propertyRequestDto.getPropertyTypeId()).get();
        if (type != null) {
            property.setType(type);
        }
        LocationEntity location = locationRepository.findById(propertyRequestDto.getPropertyLocationId()).get();
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
        PropertyEntity property = getPropertyMethod(propertyId);
        propertyRepository.delete(property);
        return mapper.propertyToPropertyResponseDto(property);
    }

    @Override
    public PropertyResponseDto editProperty(PropertyRequestDto propertyRequestDto, String propertyId) {
        PropertyEntity propertyToEdit = getPropertyMethod(propertyId);
        //

        //
        propertyRepository.save(propertyToEdit);
        return mapper.propertyToPropertyResponseDto(propertyToEdit);
    }

    @Override
    public PropertyResponseDto updateTypeFromProperty(String typeId, String propertyId) {
        PropertyEntity property = propertyRepository.findById(propertyId).get();
        TypeEntity type = typeRepository.findById(typeId).get();
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
        PropertyEntity property = propertyRepository.findById(propertyId).get();
        LocationEntity location = locationRepository.findById(locationId).get();
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
        FeatureEntity feature = featureRepository.findById(featureId).get();
        PropertyEntity property = propertyRepository.findById(propertyId).get();
        if (feature != null && property != null) {
            property.getFeatures().add(feature);
            propertyRepository.save(property);
            return mapper.propertyToPropertyResponseDto(property);
        }
        return null;
    }

    @Override
    public PropertyResponseDto deleteFeatureFromProperty(String featureId, String propertyId) {
        FeatureEntity feature = featureRepository.findById(featureId).get();
        PropertyEntity property = propertyRepository.findById(propertyId).get();
        if (feature != null && property != null) {
            property.getFeatures().remove(feature);
            propertyRepository.save(property);
            return mapper.propertyToPropertyResponseDto(property);
        }
        return null;
    }


    // Service internal methods
    public PropertyEntity getPropertyMethod(String propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow(() ->
                new IllegalArgumentException("Property not found: "+propertyId));
    }
     */
}
