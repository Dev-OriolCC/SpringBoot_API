package springboot.realstate_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.requestDto.UserRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;
import springboot.realstate_api.dto.responseDto.UserResponseDto;
import springboot.realstate_api.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getUsers")
    public ResponseEntity<List<UserResponseDto>> getProperties() {
        List<UserResponseDto> userResponseDtoList = userService.getUsers();
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("addUser")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody final UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
    // Edit User

    //

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable final UUID id) {
        UserResponseDto userResponseDto = userService.deleteUser(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // Relational Methods



}