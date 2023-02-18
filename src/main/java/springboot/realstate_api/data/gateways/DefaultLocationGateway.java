package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.LocationEntity;
import springboot.realstate_api.data.repositories.LocationRepository;
import springboot.realstate_api.domain.locations.Location;
import springboot.realstate_api.domain.locations.LocationGateway;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultLocationGateway implements LocationGateway {

    private final LocationRepository locationRepository;

    @Override
    public List<Location> getLocations() {
        List<LocationEntity> locationEntities = locationRepository.findAll();
        return locationEntities.stream().map(this::toModel).collect(toList());
    }

    @Override
    public Location create(Location location) {
        location.setId(UUID.randomUUID().toString());
        return toModel(locationRepository.save(toEntity(location)));
    }

    @Override
    public Location getLocation(String locationId) {
        LocationEntity locationEntity = locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Error"));
        return toModel(locationEntity);
    }

    @Override
    public Location delete(String locationId) {
        LocationEntity locationEntity = locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Error"));
        locationRepository.delete(locationEntity);
        return toModel(locationEntity);
    }

    private Location toModel(LocationEntity locationEntity) {
        return Location.builder()
                .id(locationEntity.getId())
                .state(locationEntity.getState())
                .country(locationEntity.getCountry())
                .city(locationEntity.getCity())
                .avenue(locationEntity.getAvenue())
                .street(locationEntity.getStreet())
                .zipcode(locationEntity.getZipcode())
                .createdAt(locationEntity.getCreatedAt())
                .updatedAt(locationEntity.getUpdatedAt())
                .deleted(locationEntity.isDeleted())
                .build();
    }


    private LocationEntity toEntity(Location location) {
        return LocationEntity.builder()
                .id(location.getId())
                .state(location.getState())
                .country(location.getCountry())
                .city(location.getCity())
                .avenue(location.getAvenue())
                .street(location.getStreet())
                .zipcode(location.getZipcode())
                .createdAt(location.getCreatedAt())
                .updatedAt(location.getUpdatedAt())
                .deleted(location.isDeleted())
                .build();
    }

}
