package springboot.realstate_api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;
import springboot.realstate_api.domain.properties.PropertyService;

import java.util.List;

@RestController
@RequestMapping("property")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/getProperties")
    public ResponseEntity<List<PropertyResponseDto>> getProperties() {
        List<PropertyResponseDto> propertyResponseDtoList = propertyService.getProperties();
        return new ResponseEntity<>(propertyResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("postProperty")
    public ResponseEntity<PropertyResponseDto> addProperty(@RequestBody final PropertyRequestDto propertyRequestDto) {
        PropertyResponseDto propertyResponseDto = propertyService.addProperty(propertyRequestDto);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }
    // Edit Property
    // ****
    //
    @DeleteMapping("deleteProperty/{id}")
    public ResponseEntity<PropertyResponseDto> deleteProperty(@PathVariable final String id) {
        PropertyResponseDto propertyResponseDto = propertyService.deleteProperty(id);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }

    // Relational Methods
    @PutMapping("updatePropertyType/{typeId}/from/{propertyId}")
    public ResponseEntity<PropertyResponseDto> updateTypeFromProperty(@PathVariable final String typeId,
                                                                      @PathVariable final String propertyId) {
        PropertyResponseDto propertyResponseDto = propertyService.updateTypeFromProperty(typeId, propertyId);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }

    @PutMapping("updatePropertyLocation/{locationId}/from/{propertyId}")
    public ResponseEntity<PropertyResponseDto> updateLocationFromProperty(@PathVariable final String locationId,
                                                                      @PathVariable final String propertyId) {
        PropertyResponseDto propertyResponseDto = propertyService.updateLocationFromProperty(locationId, propertyId);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }

    @PutMapping("addFeature/{featureId}/to/{propertyId}")
    public ResponseEntity<PropertyResponseDto> addFeatureToProperty(@PathVariable final String featureId,
                                                                          @PathVariable final String propertyId) {
        PropertyResponseDto propertyResponseDto = propertyService.addFeatureToProperty(featureId, propertyId);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }

    @PutMapping("deleteFeature/{featureId}/from/{propertyId}")
    public ResponseEntity<PropertyResponseDto> deleteFeatureFromProperty(@PathVariable final String featureId,
                                                                    @PathVariable final String propertyId) {
        PropertyResponseDto propertyResponseDto = propertyService.deleteFeatureFromProperty(featureId, propertyId);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }

}
