package springboot.realstate_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.mapper;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;
import springboot.realstate_api.model.Location;
import springboot.realstate_api.model.Property;
import springboot.realstate_api.model.Type;
import springboot.realstate_api.model.User;
import springboot.realstate_api.repository.LocationRepository;
import springboot.realstate_api.repository.PropertyRepository;
import springboot.realstate_api.repository.TypeRepository;
import springboot.realstate_api.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final TypeRepository typeRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, TypeRepository typeRepository, LocationRepository locationRepository, UserRepository userRepository) {
        this.propertyRepository = propertyRepository;
        this.typeRepository = typeRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
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


    // Service internal methods
    public Property getPropertyMethod(String propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow(() ->
                new IllegalArgumentException("Property not found: "+propertyId));
    }
}
