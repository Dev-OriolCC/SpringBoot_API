package springboot.realstate_api.domain.locations;

import java.util.List;

public interface LocationGateway {
    public List<Location> getLocations();
    public Location create(Location location);
    public Location getLocation(String locationId);
    public Location delete(String locationId);
}
