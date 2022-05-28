package springboot.realstate_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.FeatureRequestDto;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;
import springboot.realstate_api.service.PropertyService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("property")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("getProperties")
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

    @DeleteMapping("deleteProperty/{id}")
    public ResponseEntity<PropertyResponseDto> deleteProperty(@PathVariable final UUID id) {
        PropertyResponseDto propertyResponseDto = propertyService.deleteProperty(id);
        return new ResponseEntity<>(propertyResponseDto, HttpStatus.OK);
    }

    // Relational Methods
}
