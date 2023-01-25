package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.repositories.UserRepository;
import springboot.realstate_api.domain.users.User;
import springboot.realstate_api.domain.users.UserGateway;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultUserGateway implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(this::toModel).collect(toList());
    }

    @Override
    public User create(User user) {
        return toModel(userRepository.save(toEntity(user)));
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

    private User toModel(UserEntity userEntity) {
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
                .deleted(userEntity.getDeleted())
                .build();
    }

    private UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .contact_email(user.getContact_email())
                .password(user.getPassword())
                .mobile(user.getMobile())
                .twitter(user.getTwitter())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.getDeleted())
                .build();
    }

}
