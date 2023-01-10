package springboot.realstate_api.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.realstate_api.web.dto.mapper;
import springboot.realstate_api.web.dto.requestDto.UserRequestDto;
import springboot.realstate_api.web.dto.responseDto.UserResponseDto;
import springboot.realstate_api.data.entities.Location;
import springboot.realstate_api.data.entities.Role;
import springboot.realstate_api.auth.entity.User;
import springboot.realstate_api.data.repositories.LocationRepository;
import springboot.realstate_api.data.repositories.RoleRepository;
import springboot.realstate_api.auth.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LocationRepository locationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return mapper.userToUserResponseDtos(users);
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(userRequestDto.getName());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setContact_email(userRequestDto.getContact_email());
        user.setTwitter(userRequestDto.getTwitter());
        user.setMobile(userRequestDto.getMobile());
        // Plain Text
        //user.setPassword(userRequestDto.getPassword());
        // Hash
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        // Relational Data
        if (userRequestDto.getRoleId() != null) {
            Role role = roleRepository.findById(userRequestDto.getRoleId()).get();
            user.setRole(role);
        } else {
            // Default role = "user"
            Role role = roleRepository.findById("77a3c3fc-eeb8-11ec-b3a9-d493900984c5").get();
            user.setRole(role);
        }

        userRepository.save(user);
        return mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto deleteUser(String userId) {
        User user = userRepository.findById(userId).get();
        return mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto editUser(UserRequestDto UserRequestDto, String userId) {
        User userToEdit = userRepository.findById(userId).get();
        //

        //
        userRepository.save(userToEdit);
        return mapper.userToUserResponseDto(userToEdit);
    }

    // Relational Data

    @Override
    public UserResponseDto addRoleToUser(String roleId, String userId) {
        User user = userRepository.findById(userId).get();
        if (Objects.nonNull(user.getRole())) {
            throw new RuntimeException("Person has role");
        }
        Role role = roleRepository.findById(roleId).get();
        user.setRole(role);
        userRepository.save(user);
        return mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto addLocationToUser(String locationId, String userId) {
        User user = userRepository.findById(userId).get();
        if (Objects.nonNull(user.getLocation())) {
            throw new RuntimeException("Person has location");
        }
        Location location = locationRepository.findById(locationId).get();
        user.setLocation(location);
        userRepository.save(user);
        return mapper.userToUserResponseDto(user);
    }
}
