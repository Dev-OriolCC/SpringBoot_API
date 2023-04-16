package springboot.realstate_api.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.properties.Property;
import springboot.realstate_api.domain.users.User;
import springboot.realstate_api.domain.users.UserService;
import springboot.realstate_api.domain.users.UserServiceAuth;
import springboot.realstate_api.web.dto.PropertyRequestDto;
import springboot.realstate_api.web.dto.PropertyResponseDto;
import springboot.realstate_api.domain.properties.PropertyGateway;
import springboot.realstate_api.web.dto.UserRequestDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/property")
@AllArgsConstructor
public class PropertyController {
    private final PropertyGateway propertyService;
    UserService userService;
    @Autowired
    public PropertyController(PropertyGateway propertyService) {
        this.propertyService = propertyService;
    }

    //TODO: Refactor all endpoints to have an userID as path variable..
    @GetMapping("/me")
    public ResponseEntity<Void> getAuthUserExample(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {

//        String email = jwtUtil.getUsernameFromToken(token);
//        UserRegisteredDTO userAuthenticated = toDTO(service.findByEmail(email));
        //jwtUtility.getUsernameFromToken(token);

        return null;
    }

    @GetMapping
    public ResponseEntity<List<PropertyResponseDto>> getProperties() {
        List<PropertyResponseDto> propertyResponseDtoList = propertyService.getProperties().stream().map(this::toDto2).collect(toList());
        return new ResponseEntity<>(propertyResponseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PropertyResponseDto> create(
            @RequestBody final PropertyRequestDto propertyRequestDto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {

        //String email = jwtUtility.getUsernameFromToken(token);
        //User user = userService.findUserByEmail(email);
        //propertyRequestDto.setPropertyUserId(user.getId()); // Id assigned from token user.
        return new ResponseEntity<>(toDto2(propertyService.create(toModel(propertyRequestDto))), HttpStatus.OK);
    }
    // Edit Property
    // ****
    //
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        //PropertyResponseDto propertyResponseDto = propertyService.deleteProperty(id);
        propertyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Relational Methods
    @PutMapping("/{typeId}/from/{propertyId}")
    public ResponseEntity<PropertyResponseDto> updateTypeFromProperty(@PathVariable final String typeId,
                                                                      @PathVariable final String propertyId) {
        // PropertyResponseDto propertyResponseDto = propertyService.updateTypeFromProperty(typeId, propertyId);
        return new ResponseEntity<>(toDto2(propertyService.updateTypeFromProperty(typeId, propertyId)), HttpStatus.OK);
    }

    @PutMapping("updatePropertyLocation/{locationId}/from/{propertyId}")
    public ResponseEntity<PropertyResponseDto> updateLocationFromProperty(@PathVariable final String locationId,
                                                                      @PathVariable final String propertyId) {
        // PropertyResponseDto propertyResponseDto = propertyService.updateLocationFromProperty(locationId, propertyId);
        return new ResponseEntity<>(toDto2(propertyService.updateLocationFromProperty(locationId, propertyId)), HttpStatus.OK);
    }

    @PutMapping("addFeature/{featureId}/to/{propertyId}")
    public ResponseEntity<PropertyResponseDto> addFeatureToProperty(@PathVariable final String featureId,
                                                                          @PathVariable final String propertyId) {
        // PropertyResponseDto propertyResponseDto = propertyService.addFeatureToProperty(featureId, propertyId);
        return new ResponseEntity<>(toDto2(propertyService.addFeatureToProperty(featureId, propertyId)), HttpStatus.OK);
    }

    @PutMapping("deleteFeature/{featureId}/from/{propertyId}")
    public ResponseEntity<PropertyResponseDto> deleteFeatureFromProperty(@PathVariable final String featureId,
                                                                    @PathVariable final String propertyId) {
        // PropertyResponseDto propertyResponseDto = propertyService.deleteFeatureFromProperty(featureId, propertyId);
        return new ResponseEntity<>(toDto2(propertyService.deleteFeatureFromProperty(featureId, propertyId)), HttpStatus.OK);
    }

    public Property toModel(PropertyRequestDto propertyRequestDto) {
        return Property.builder()
                .id(propertyRequestDto.getId())
                .title(propertyRequestDto.getTitle())
                .price(propertyRequestDto.getPrice())
                .description(propertyRequestDto.getDescription())
                .details(propertyRequestDto.getDetails())
                .squarefeet(propertyRequestDto.getSquarefeet())
                .baths(propertyRequestDto.getBaths())
                .beds(propertyRequestDto.getBeds())
                .state(propertyRequestDto.getState())
                .date_published(propertyRequestDto.getDate_published())
                .year_built(propertyRequestDto.getYear_built())
                // Relationship
//                .user(propertyRequestDto.get)
                .createdAt(propertyRequestDto.getCreatedAt())
                .updatedAt(propertyRequestDto.getUpdatedAt())
                .deleted(propertyRequestDto.isDeleted())
                .build();
    }

    public PropertyResponseDto toDto2(Property property) {
        return PropertyResponseDto.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(property.getPrice())
                .description(property.getDescription())
                .details(property.getDetails())
                .squarefeet(property.getSquarefeet())
                .baths(property.getBaths())
                .beds(property.getBeds())
                .state(property.getState())
                .date_published(property.getDate_published())
                .year_built(property.getYear_built())
                .createdAt(property.getCreatedAt())
                .updatedAt(property.getUpdatedAt())
                .deleted(property.isDeleted())
                .build();
    }

    public PropertyRequestDto toDto(Property property) {
        return PropertyRequestDto.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(property.getPrice())
                .description(property.getDescription())
                .details(property.getDetails())
                .squarefeet(property.getSquarefeet())
                .baths(property.getBaths())
                .beds(property.getBeds())
                .state(property.getState())
                .date_published(property.getDate_published())
                .year_built(property.getYear_built())
                .createdAt(property.getCreatedAt())
                .updatedAt(property.getUpdatedAt())
                .deleted(property.isDeleted())
                .build();
    }


}
