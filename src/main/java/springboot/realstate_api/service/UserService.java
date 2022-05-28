package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.UserRequestDto;
import springboot.realstate_api.dto.responseDto.UserResponseDto;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    public List<UserResponseDto> getUsers();
    public UserResponseDto addUser(UserRequestDto UserRequestDto);
    public UserResponseDto deleteUser(UUID userId);
    public UserResponseDto editUser(UserRequestDto UserRequestDto, UUID userId);
    // Relational Data

}
