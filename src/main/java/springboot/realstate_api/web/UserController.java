package springboot.realstate_api.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.users.User;
import springboot.realstate_api.web.dto.UserRequestDto;
import springboot.realstate_api.web.dto.UserResponseDto;
import springboot.realstate_api.domain.users.UserGateway;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    //TODO: FINISH
    private final UserGateway userService;

    RoleController roleController;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getUsers().stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody final UserRequestDto userRequestDto) {
        return new ResponseEntity<>(toDto(userService.create(toModel(userRequestDto))), HttpStatus.OK);
    }
    // Edit User

    //

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Relational Methods
    @PutMapping("addRole/{roleId}/to/{userId}")
    public ResponseEntity<UserResponseDto> addRole(@PathVariable final String roleId,
                                                   @PathVariable final String userId) {
        return new ResponseEntity<>(toDto(userService.addRoleToUser(roleId, userId)), HttpStatus.OK);
    }

    @PutMapping("addLocation/{locationId}/to/{userId}")
    public ResponseEntity<UserResponseDto> addLocation(@PathVariable final String locationId,
                                                   @PathVariable final String userId) {
        return new ResponseEntity<>(toDto(userService.addLocationToUser(locationId, userId)), HttpStatus.OK);
    }



    public User toModel(UserResponseDto user) {
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .contact_email(user.getContact_email())
                .twitter(user.getTwitter())
                .mobile(user.getMobile())
                //
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.isDeleted())
                .build();
    }

    public User toModel(UserRequestDto user) {
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .contact_email(user.getContact_email())
                .twitter(user.getTwitter())
                .mobile(user.getMobile())
                .roleId(user.getRoleId())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.isDeleted())
                .build();
    }

    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .contact_email(user.getContact_email())
                .twitter(user.getTwitter())
                .mobile(user.getMobile())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.isDeleted())
                // Relationship
                .role(roleController.toDto(user.getRole()))
                .build();
    }

    public UserRequestDto toDtoUser(User user) {
        return UserRequestDto.builder()
                .email(user.getEmail())
                .build();
    }


}
