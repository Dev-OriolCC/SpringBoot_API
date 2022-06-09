package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.LocationRequestDto;
import springboot.realstate_api.model.Location;

import java.util.List;

@Service
public interface LocationService {
    public List<Location> getLocations();
    public LocationRequestDto addLocation(LocationRequestDto locationRequestDto);
    public LocationRequestDto getLocation(String locationId);
    public LocationRequestDto deleteLocation(String locationId);
}
