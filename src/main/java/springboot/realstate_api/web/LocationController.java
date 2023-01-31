package springboot.realstate_api.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.locations.Location;
import springboot.realstate_api.domain.locations.LocationService;
import springboot.realstate_api.web.dto.LocationDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;
    @GetMapping
    public ResponseEntity<List<LocationDto>> getLocations() {
        List<LocationDto> locationDtos = locationService.getLocations().stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDto> create(@RequestBody LocationDto locationRequestDto) {
        return new ResponseEntity<>(toDto(locationService.create(toModel(locationRequestDto))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable String id) {
        return new ResponseEntity<>(toDto(locationService.getLocation(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationDto> delete(@PathVariable final String id) {
        return new ResponseEntity<>(toDto(locationService.delete(id)), HttpStatus.OK);
    }

    public Location toModel(LocationDto locationDto) {
        return Location.builder()
                .id(locationDto.getId())
                .country(locationDto.getCountry())
                .state(locationDto.getState())
                .zipcode(locationDto.getZipcode())
                .city(locationDto.getCity())
                .avenue(locationDto.getAvenue())
                .street(locationDto.getStreet())
                .createdAt(locationDto.getCreatedAt())
                .updatedAt(locationDto.getUpdatedAt())
                .deleted(locationDto.isDeleted())
                .build();
    }

    public LocationDto toDto(Location location) {
        return LocationDto.builder()
                .id(location.getId())
                .country(location.getCountry())
                .state(location.getState())
                .zipcode(location.getZipcode())
                .city(location.getCity())
                .avenue(location.getAvenue())
                .street(location.getStreet())
                .createdAt(location.getCreatedAt())
                .updatedAt(location.getUpdatedAt())
                .deleted(location.isDeleted())
                .build();
    }

}
