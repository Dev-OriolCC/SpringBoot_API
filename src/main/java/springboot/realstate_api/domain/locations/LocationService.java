package springboot.realstate_api.domain.locations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationGateway locationGateway;

    public List<Location> getLocations() {
        return locationGateway.getLocations();
    }

    public Location create(Location location) {
        return locationGateway.create(location);
    }

    public Location getLocation(String locationId) {
        return locationGateway.getLocation(locationId);
    }

    public Location delete(String locationId) {
        return locationGateway.delete(locationId);
    }
}
