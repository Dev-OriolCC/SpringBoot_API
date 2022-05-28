package springboot.realstate_api.dto;

import springboot.realstate_api.dto.requestDto.*;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;
import springboot.realstate_api.dto.responseDto.UserResponseDto;
import springboot.realstate_api.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Issue with mapper
 * All parameters on dtos should return List<Model> NOT Set<Model>
 */

public class mapper {
    // 1.- --- --- --- --- --- --- --- --- --- ---
    public static PropertyResponseDto propertyToPropertyResponseDto(Property property) {
        PropertyResponseDto propertyResponseDto = new PropertyResponseDto();
        propertyResponseDto.setTitle(property.getTitle());
        propertyResponseDto.setPrice(property.getPrice());
        propertyResponseDto.setDescription(property.getDescription());
        propertyResponseDto.setDetails(property.getDetails());
        propertyResponseDto.setSquarefeet(property.getSquarefeet());
        propertyResponseDto.setBaths(property.getBaths());
        propertyResponseDto.setBeds(property.getBeds());
        propertyResponseDto.setState(property.getState());
        propertyResponseDto.setDate_published(property.getDate_published());
        propertyResponseDto.setYear_built(property.getYear_built());
        // Relationship Data
        propertyResponseDto.setType(typeToTypeRequestDto(property.getType()));
        propertyResponseDto.setLocation(locationToLocationRequestDto(property.getLocation()));
        propertyResponseDto.setUser(userToUserResponseDto(property.getUser())); // [TEST]
        propertyResponseDto.setFeatures(property.getFeatures()); // Changed propertyResponseDto_Feature
        //propertyResponseDto.setPhotos(property.getPhotos()); // Changed photosResponseDto_Photo
        return propertyResponseDto;
    }
    public static List<PropertyResponseDto> propertyToPropertyResponseDtos(List<Property> properties) {
        List<PropertyResponseDto> propertyResponseDtos = new ArrayList<>();
        for (Property property: properties) {
            propertyResponseDtos.add(propertyToPropertyResponseDto(property));
        }
        return propertyResponseDtos;
    }
    // 2.- --- --- --- --- --- --- --- --- --- ---
    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setLastname(user.getLastname());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setContact_email(user.getContact_email());
        userResponseDto.setTwitter(user.getTwitter());
        userResponseDto.setMobile(user.getMobile());
        userResponseDto.setNumberProperties(user.getProperties().size());
        // Relationship Data
        userResponseDto.setRole(roleToRoleRequestDto(user.getRole()));
        userResponseDto.setLocation(locationToLocationRequestDto(user.getLocation()));
        //userResponseDto.setProperties(user.getProperties()); // [TEST] Changed Dto to Model
        return userResponseDto;
    }
    public static List<UserResponseDto> userToUserResponseDtos(List<User> users) {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user:  users) {
            userResponseDtos.add(userToUserResponseDto(user));
        }
        return userResponseDtos;
    }

    //  ===  Single items ===
    public static TypeRequestDto typeToTypeRequestDto(Type type) {
        TypeRequestDto typeRequestDto = new TypeRequestDto();
        typeRequestDto.setName(type.getName());
        return typeRequestDto;
    }
    public static LocationRequestDto locationToLocationRequestDto(Location location) {
        LocationRequestDto locationRequestDto = new LocationRequestDto();
        locationRequestDto.setCountry(location.getCountry());
        locationRequestDto.setState(location.getState());
        locationRequestDto.setCity(location.getCity());
        locationRequestDto.setZipcode(location.getZipcode());
        locationRequestDto.setAvenue(location.getAvenue());
        locationRequestDto.setStreet(location.getStreet());
        return locationRequestDto;
    }
    public static RoleRequestDto roleToRoleRequestDto(Role role) {
        RoleRequestDto roleRequestDto =  new RoleRequestDto();
        roleRequestDto.setName(role.getName());
        return roleRequestDto;
    }
    //
    public static FeatureRequestDto featureToFeatureRequestDto(Feature feature) {
        FeatureRequestDto featureRequestDto = new FeatureRequestDto();
        featureRequestDto.setName(feature.getName());
        return featureRequestDto;
    }
    public static List<FeatureRequestDto> featureToFeatureRequestDtos(List<Feature> features) {
        List<FeatureRequestDto> featureRequestDtos = new ArrayList<>();
        for (Feature feature : features) {
            featureRequestDtos.add(featureToFeatureRequestDto(feature));
        }
        return featureRequestDtos;
    }
    //
    public static PhotoRequestDto photoToPhotoRequestDto(Photo photo) {
        PhotoRequestDto photoRequestDto = new PhotoRequestDto();
        photoRequestDto.setUrl(photo.getUrl());
        photoRequestDto.setAlt(photo.getAlt());
        return photoRequestDto;
    }
    public static List<PhotoRequestDto> photoToPhotoRequestDtos(List<Photo> photos) {
        List<PhotoRequestDto> photoRequestDtos = new ArrayList<>();
        for (Photo photo : photos) {
            photoRequestDtos.add(photoToPhotoRequestDto(photo));
        }
        return photoRequestDtos;
    }

}
