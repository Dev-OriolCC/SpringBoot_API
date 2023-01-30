package springboot.realstate_api.data.gateways;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.FeatureEntity;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.repositories.RoleRepository;
import springboot.realstate_api.domain.features.Feature;
import springboot.realstate_api.domain.roles.Role;
import springboot.realstate_api.domain.roles.RoleGateway;
import springboot.realstate_api.domain.users.User;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultRoleGateway implements RoleGateway {

    private final RoleRepository roleRepository;
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll().stream().map(this::toModel).collect(toList());
    }

    @Override
    public Role create(Role role) {
        role.setId(UUID.randomUUID().toString());
        return toModel(roleRepository.save(toEntity(role)));
    }

    @Override
    public Role getRole(String roleId) {
        return toModel(roleRepository.getById(roleId));
    }

    @Override
    public Role delete(String roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Error"));

        roleRepository.delete(roleEntity);
        return toModel(roleEntity);
    }

    private Role toModel(RoleEntity roleEntity) {
        return Role.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getName())
                .createdAt(roleEntity.getCreatedAt())
                .updatedAt(roleEntity.getUpdatedAt())
                .deleted(roleEntity.isDeleted())
                .build();
    }

    private RoleEntity toEntity(Role role) {
        return RoleEntity.builder()
                .id(role.getId())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .deleted(role.isDeleted())
                .build();
    }
}
