package springboot.realstate_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.mapper;
import springboot.realstate_api.dto.requestDto.UserRequestDto;
import springboot.realstate_api.dto.responseDto.UserResponseDto;
import springboot.realstate_api.model.User;
import springboot.realstate_api.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return mapper.userToUserResponseDtos(users);
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(userRequestDto.getName());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setContact_email(userRequestDto.getContact_email());
        user.setTwitter(userRequestDto.getTwitter());
        user.setMobile(userRequestDto.getMobile());

        // Relational Data
        userRepository.save(user);
        return mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto deleteUser(UUID userId) {
        User user = userRepository.findById(userId).get();
        return mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto editUser(UserRequestDto UserRequestDto, UUID userId) {
        User userToEdit = userRepository.findById(userId).get();
        //

        //
        userRepository.save(userToEdit);
        return mapper.userToUserResponseDto(userToEdit);
    }
}
