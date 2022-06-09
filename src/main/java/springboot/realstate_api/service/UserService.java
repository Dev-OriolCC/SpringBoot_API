package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.UserRequestDto;
import springboot.realstate_api.dto.responseDto.UserResponseDto;

import java.util.List;

@Service
public interface UserService {

    public List<UserResponseDto> getUsers();
    public UserResponseDto addUser(UserRequestDto UserRequestDto);
    public UserResponseDto deleteUser(String userId);
    public UserResponseDto editUser(UserRequestDto UserRequestDto, String userId);
    // Relational Data
    public UserResponseDto addRoleToUser(String roleId, String userId);
    public UserResponseDto addLocationToUser(String locationId, String userId);
}
