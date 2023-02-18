package springboot.realstate_api.domain.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserGateway userGateway;
    public List<User> getUsers() {
        return userGateway.getUsers();
    }

    public User create(User user) {
        return userGateway.create(user);
    }

    public User delete(String userId) {
        return userGateway.delete(userId);
    }

    public User editUser(User user, String userId) {
        return userGateway.editUser(user, userId);
    }

    public User addRoleToUser(String roleId, String userId) {
        return userGateway.addRoleToUser(roleId, userId);
    }

    public User addLocationToUser(String locationId, String userId) {
        return userGateway.addLocationToUser(locationId, userId);
    }

    public User findUserByEmail(String email) {
        return userGateway.findByEmail(email);
    }


    //test
    /*
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
            RoleEntity role = roleRepository.findById(userRequestDto.getRoleId()).get();
            user.setRole(role);
        } else {
            // Default role = "user"
            RoleEntity role = roleRepository.findById("77a3c3fc-eeb8-11ec-b3a9-d493900984c5").get();
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
        RoleEntity role = roleRepository.findById(roleId).get();
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
        LocationEntity location = locationRepository.findById(locationId).get();
        user.setLocation(location);
        userRepository.save(user);
        return mapper.userToUserResponseDto(user);
    }
     */
}
