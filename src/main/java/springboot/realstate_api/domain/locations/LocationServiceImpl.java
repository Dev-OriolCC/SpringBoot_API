package springboot.realstate_api.domain.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.mapper;
import springboot.realstate_api.dto.requestDto.LocationRequestDto;
import springboot.realstate_api.data.entities.Location;
import springboot.realstate_api.data.repositories.LocationRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getLocations() { // Change later to DTO response
        List<Location> locationList = locationRepository.findAll();
        return locationList;
        //
    }

    @Override
    public LocationRequestDto addLocation(LocationRequestDto locationRequestDto) {
        Location location = new Location();
        location.setId(UUID.randomUUID().toString());
        location.setCountry(locationRequestDto.getCountry());
        location.setState(locationRequestDto.getState());
        location.setZipcode(locationRequestDto.getZipcode());
        location.setCity(locationRequestDto.getCity());
        location.setAvenue(locationRequestDto.getAvenue());
        location.setStreet(locationRequestDto.getStreet());
        locationRepository.save(location);
        return mapper.locationToLocationRequestDto(location);
    }

    @Override
    public LocationRequestDto getLocation(String locationId) {
        return mapper.locationToLocationRequestDto(getLocationMethod(locationId));
    }

    @Override
    public LocationRequestDto deleteLocation(String locationId) {
        Location location = getLocationMethod(locationId);
        locationRepository.delete(location);
        return mapper.locationToLocationRequestDto(location);
    }

    // Service internal methods
    public Location getLocationMethod(String locationId) {
        return locationRepository.findById(locationId).orElseThrow(() ->
                new IllegalArgumentException("Location not found"+locationId));
    }
}
