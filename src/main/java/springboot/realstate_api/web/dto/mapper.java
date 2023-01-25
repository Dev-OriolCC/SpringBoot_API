package springboot.realstate_api.web.dto;

import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Issue with mapper
 * All parameters on dtos should return List<Model> NOT Set<Model>
 */

public class mapper {
    // 1.- --- --- --- --- --- --- --- --- --- ---
    public static PropertyResponseDto propertyToPropertyResponseDto(PropertyEntity property) {
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
        if (property.getType() != null) {
            propertyResponseDto.setType(typeToTypeRequestDto(property.getType()));
        }
        if(property.getLocation() != null){
            propertyResponseDto.setLocation(locationToLocationRequestDto(property.getLocation()));
        }
        if(property.getUser() != null) {
            propertyResponseDto.setUser(userToUserResponseDto(property.getUser())); // [TEST]
        }
        if(property.getFeatures() != null) {
            propertyResponseDto.setFeatures(property.getFeatures()); // Changed propertyResponseDto_Feature
        }
        if (property.getPhotos() != null) {
            propertyResponseDto.setPhotos(property.getPhotos()); // Changed photosResponseDto_Photo
        }
        //propertyResponseDto.setPhotos(property.getPhotos()); // Changed photosResponseDto_Photo
        return propertyResponseDto;
    }
    public static List<PropertyResponseDto> propertyToPropertyResponseDtos(List<PropertyEntity> properties) {
        List<PropertyResponseDto> propertyResponseDtos = new ArrayList<>();
        for (PropertyEntity property: properties) {
            propertyResponseDtos.add(propertyToPropertyResponseDto(property));
        }
        return propertyResponseDtos;
    }
    // 2.- --- --- --- --- --- --- --- --- --- ---
    public static UserResponseDto userToUserResponseDto(UserEntity user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setLastname(user.getLastname());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setContact_email(user.getContact_email());
        userResponseDto.setTwitter(user.getTwitter());
        userResponseDto.setMobile(user.getMobile());
//        if (user.getProperties().size() > 0) {
//            userResponseDto.setNumberProperties(user.getProperties().size());
//        }


        // Relationship Data
        if (user.getRole() != null) {
            userResponseDto.setRole(roleToRoleRequestDto(user.getRole()));
        }
        if (user.getLocation() != null) {
            userResponseDto.setLocation(locationToLocationRequestDto(user.getLocation()));
        }
//
        //userResponseDto.setProperties(user.getProperties()); // [TEST] Changed Dto to Model
        return userResponseDto;
    }
    public static List<UserResponseDto> userToUserResponseDtos(List<UserEntity> users) {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (UserEntity user:  users) {
            userResponseDtos.add(userToUserResponseDto(user));
        }
        return userResponseDtos;
    }

    //  ===  Single items ===
    public static TypeDto typeToTypeRequestDto(TypeEntity type) {
        TypeDto typeRequestDto = new TypeDto();
        typeRequestDto.setName(type.getName());
        return typeRequestDto;
    }
    public static LocationDto locationToLocationRequestDto(LocationEntity location) {
        LocationDto locationRequestDto = new LocationDto();
        locationRequestDto.setCountry(location.getCountry());
        locationRequestDto.setState(location.getState());
        locationRequestDto.setCity(location.getCity());
        locationRequestDto.setZipcode(location.getZipcode());
        locationRequestDto.setAvenue(location.getAvenue());
        locationRequestDto.setStreet(location.getStreet());
        return locationRequestDto;
    }
    public static RoleDto roleToRoleRequestDto(RoleEntity role) {
        RoleDto roleRequestDto =  new RoleDto();
        roleRequestDto.setName(role.getName());
        return roleRequestDto;
    }
    //
    public static FeatureDto featureToFeatureRequestDto(FeatureEntity feature) {
        FeatureDto featureRequestDto = new FeatureDto();
        featureRequestDto.setName(feature.getName());
        return featureRequestDto;
    }
    public static List<FeatureDto> featureToFeatureRequestDtos(List<FeatureEntity> features) {
        List<FeatureDto> featureRequestDtos = new ArrayList<>();
        for (FeatureEntity feature : features) {
            featureRequestDtos.add(featureToFeatureRequestDto(feature));
        }
        return featureRequestDtos;
    }
    //
    public static PhotoDto photoToPhotoRequestDto(PhotoEntity photo) {
        PhotoDto photoRequestDto = new PhotoDto();
        photoRequestDto.setUrl(photo.getUrl());
        photoRequestDto.setName(photo.getName());
        return photoRequestDto;
    }
    public static List<PhotoDto> photoToPhotoRequestDtos(List<PhotoEntity> photos) {
        List<PhotoDto> photoRequestDtos = new ArrayList<>();
        for (PhotoEntity photo : photos) {
            photoRequestDtos.add(photoToPhotoRequestDto(photo));
        }
        return photoRequestDtos;
    }

}
