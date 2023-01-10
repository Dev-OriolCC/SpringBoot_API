package springboot.realstate_api.domain.locations;

import springboot.realstate_api.web.dto.requestDto.LocationRequestDto;

import java.util.List;

public interface LocationGateway {
    public List<LocationRequestDto> getLocations();
    public LocationRequestDto addLocation(Location location);
    public LocationRequestDto getLocation(String locationId);
    public LocationRequestDto deleteLocation(String locationId);
}
