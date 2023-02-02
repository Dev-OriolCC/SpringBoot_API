package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.repositories.RoleRepository;
import springboot.realstate_api.data.repositories.UserRepository;
import springboot.realstate_api.domain.roles.Role;
import springboot.realstate_api.domain.users.User;
import springboot.realstate_api.domain.users.UserGateway;
import springboot.realstate_api.web.dto.RoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultUserGateway implements UserGateway {

    private final DefaultRoleGateway defaultRoleGateway; // test

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(this::toModel).collect(toList());
    }

    @Override
    public User create(User user) {

        // Refactor this...
        addRoleAutomatic(user);
        user.setId(UUID.randomUUID().toString());

        // Get real entity role
        user.getRole();
        user.getRoleId();
        return toModel(userRepository.save(toEntity(user, defaultRoleGateway.toEntity(user.getRole()))));
    }

    @Override
    public User delete(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Error"));
        userRepository.delete(userEntity);
        return toModel(userEntity);
    }

    @Override
    public User editUser(User user, String userId) {

        return null;
    }

    @Override
    public User addRoleToUser(String roleId, String userId) {
        return null;
    }

    @Override
    public User addLocationToUser(String locationId, String userId) {
        return null;
    }

//    protected Role toModel(RoleEntity role) {
//        return Role.builder()
//                .id(role.getId())
//                .name(role.getName())
//                .createdAt(role.getCreatedAt())
//                .updatedAt(role.getUpdatedAt())
//                .deleted(role.isDeleted())
//                .build();
//    }

    protected User addRoleAutomatic(User user) {
        //TODO: Need to refactor this shit...
        Optional<RoleEntity> roleEntity;
        if (user.getRoleId() == null) {
            roleEntity = roleRepository.findByName("ADMIN");
            if(roleEntity.isEmpty()) {
                roleEntity = Optional.ofNullable(defaultRoleGateway.createAdminRole());
            }
                    //.orElse(defaultRoleGateway.createAdminRole());  //.orElseThrow(() -> new RuntimeException("NOT FOUND"));
            user.setRoleId(roleEntity.get().getId());
            System.out.println("Added Role");
        } else {
            //roleEntity = roleRepository.findById(user.getRoleId()).orElseThrow(() -> new RuntimeException("NOT FOUND"));
            roleEntity = Optional.ofNullable(roleRepository.findById(user.getRoleId()).orElseThrow(() -> new RuntimeException("Not Found")));
            user.setRoleId(roleEntity.get().getId());
            System.out.println("Find role and add it....");
        }
        user.setRole(defaultRoleGateway.toModel(roleEntity.get()));
        return user;
    }

    protected User toModel(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .contact_email(userEntity.getContact_email())
                .password(userEntity.getPassword())
                .mobile(userEntity.getMobile())
                .twitter(userEntity.getTwitter())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .deleted(userEntity.isDeleted())
                // relationship
                .roleId(userEntity.getRole().getId())
                .role(defaultRoleGateway.toModel(userEntity.getRole()))
                .build();
    }

    protected UserEntity toEntity(User user, RoleEntity role) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .contact_email(user.getContact_email())
                .password(user.getPassword())
                .mobile(user.getMobile())
                .twitter(user.getTwitter())
                // Relationship
                .role(role)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.isDeleted())
                .build();
    }

}
