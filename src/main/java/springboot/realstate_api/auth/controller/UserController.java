package springboot.realstate_api.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.UserRequestDto;
import springboot.realstate_api.dto.responseDto.UserResponseDto;
import springboot.realstate_api.auth.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getUsers();
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody final UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
    // Edit User

    //

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable final String id) {
        UserResponseDto userResponseDto = userService.deleteUser(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // Relational Methods
    @PutMapping("addRole/{roleId}/to/{userId}")
    public ResponseEntity<UserResponseDto> addRole(@PathVariable final String roleId,
                                                   @PathVariable final String userId) {
        UserResponseDto userResponseDto = userService.addRoleToUser(roleId, userId);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PutMapping("addLocation/{locationId}/to/{userId}")
    public ResponseEntity<UserResponseDto> addLocation(@PathVariable final String locationId,
                                                   @PathVariable final String userId) {
        UserResponseDto userResponseDto = userService.addLocationToUser(locationId, userId);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }


}
