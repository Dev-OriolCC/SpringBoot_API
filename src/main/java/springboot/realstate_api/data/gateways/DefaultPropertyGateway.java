package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.LocationEntity;
import springboot.realstate_api.data.entities.PropertyEntity;
import springboot.realstate_api.data.entities.TypeEntity;
import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.repositories.PropertyRepository;
import springboot.realstate_api.data.repositories.TypeRepository;
import springboot.realstate_api.data.repositories.UserRepository;
import springboot.realstate_api.domain.properties.Property;
import springboot.realstate_api.domain.properties.PropertyGateway;
import springboot.realstate_api.web.dto.PropertyRequestDto;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultPropertyGateway implements PropertyGateway {

    private final DefaultTypeGateway defaultTypeGateway;
    private final DefaultUserGateway defaultUserGateway;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final TypeRepository typeRepository;

    @Override
    public List<Property> getProperties() {
        List<Property> properties = propertyRepository.findAll().stream().map(this::toModel).collect(toList());
        return properties;
    }

    @Override
    public Property create(Property property) {

        UserEntity userEntity = userRepository.findById(property.getUser().getId()).orElseThrow(() -> new RuntimeException("USER NOT FOUND"));
        property.setUser(defaultUserGateway.toModel(userEntity));
        // Check if user has a location to use as default...
        LocationEntity locationEntity = userEntity.getLocation();

        // Check if location is provided
        addTypeAutomatic(property);
        // Else = add default location (HOME)
        // LocationEntity locationEntity

        // Else = create it if does not exits...

        return toModel(propertyRepository.save(toEntity(property)));
    }



    @Override
    public Property delete(String propertyId) {
        PropertyEntity propertyEntity = propertyRepository.findById(propertyId).orElseThrow(()-> new RuntimeException("Error"));
        propertyRepository.delete(propertyEntity);
        return toModel(propertyEntity);
    }

    @Override
    public Property update(PropertyRequestDto propertyRequestDto, String propertyId) {
        return null;
    }

    @Override
    public Property updateTypeFromProperty(String typeId, String propertyId) {
        PropertyEntity propertyEntity = propertyRepository.findById(propertyId).orElseThrow(() -> new RuntimeException("Error"));
        TypeEntity typeEntity = typeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Error"));
        propertyEntity.setType(typeEntity);
        return toModel(propertyEntity);
    }

    @Override
    public Property updateLocationFromProperty(String locationId, String propertyId) {

        return null;
    }

    @Override
    public Property addFeatureToProperty(String featureId, String propertyId) {
        return null;
    }

    @Override
    public Property deleteFeatureFromProperty(String featureId, String propertyId) {
        return null;
    }


    // Protected methods
    protected void addTypeAutomatic(Property property) {
        Optional<TypeEntity> typeEntity;

        //if (property.getType)
    }


    protected Property toModel(PropertyEntity propertyEntity) {
        return Property.builder()
                .id(propertyEntity.getId())
                .title(propertyEntity.getTitle())
                .price(propertyEntity.getPrice())
                .description(propertyEntity.getDescription())
                .details(propertyEntity.getDetails())
                .squarefeet(propertyEntity.getSquarefeet())
                .baths(propertyEntity.getBaths())
                .beds(propertyEntity.getBeds())
                .state(propertyEntity.getState())
                .date_published(propertyEntity.getDate_published())
                .year_built(propertyEntity.getYear_built())
                // Relationship
                .type(defaultTypeGateway.toModel(propertyEntity.getType()))
                //
                .createdAt(propertyEntity.getCreatedAt())
                .updatedAt(propertyEntity.getUpdatedAt())
                .deleted(propertyEntity.isDeleted())
                .build();
    }

    protected PropertyEntity toEntity(Property property) {
        return PropertyEntity.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(property.getPrice())
                .description(property.getDescription())
                .details(property.getDetails())
                .squarefeet(property.getSquarefeet())
                .baths(property.getBaths())
                .beds(property.getBeds())
                .state(property.getState())
                .date_published(property.getDate_published())
                .year_built(property.getYear_built())
                .createdAt(property.getCreatedAt())
                .updatedAt(property.getUpdatedAt())
                .deleted(property.isDeleted())
                .location(new LocationEntity())
                .build();
    }

}
