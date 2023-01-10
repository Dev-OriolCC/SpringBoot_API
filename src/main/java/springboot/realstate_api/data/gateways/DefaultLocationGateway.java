package springboot.realstate_api.data.gateways;

import springboot.realstate_api.domain.locations.Location;
import springboot.realstate_api.domain.locations.LocationGateway;
import springboot.realstate_api.web.dto.requestDto.LocationRequestDto;

import java.util.List;

public class DefaultLocationGateway implements LocationGateway {
    @Override
    public List<LocationRequestDto> getLocations() {
        return null;
    }

    @Override
    public LocationRequestDto addLocation(Location location) {
        return null;
    }

    @Override
    public LocationRequestDto getLocation(String locationId) {
        return null;
    }

    @Override
    public LocationRequestDto deleteLocation(String locationId) {
        return null;
    }
}
