package springboot.realstate_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.LocationRequestDto;
import springboot.realstate_api.model.Location;
import springboot.realstate_api.service.LocationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    //
    @GetMapping("getLocations")
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> locationRequestDtoList = locationService.getLocations();
        return new ResponseEntity<>(locationRequestDtoList, HttpStatus.OK);
    }

    @PostMapping("postLocation")
    public ResponseEntity<LocationRequestDto> addLocation(@RequestBody final LocationRequestDto locationRequestDto) {
        LocationRequestDto locationRequestDto1 = locationService.addLocation(locationRequestDto);
        return new ResponseEntity<>(locationRequestDto1, HttpStatus.OK);
    }

    @GetMapping("getLocation/{id}")
    public ResponseEntity<LocationRequestDto> getLocation(@PathVariable final String id) {
        LocationRequestDto locationRequestDto = locationService.getLocation(id);
        return new ResponseEntity<>(locationRequestDto, HttpStatus.OK);
    }

    @DeleteMapping("deleteLocation/{id}")
    public ResponseEntity<LocationRequestDto> deleteLocation(@PathVariable final String id) {
        LocationRequestDto locationRequestDto = locationService.deleteLocation(id);
        return new ResponseEntity<>(locationRequestDto, HttpStatus.OK);
    }
}
