package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.repositories.RoleRepository;
import springboot.realstate_api.data.repositories.UserRepository;
import springboot.realstate_api.domain.roles.Role;
import springboot.realstate_api.domain.roles.RoleGateway;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultRoleGateway implements RoleGateway {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll().stream().map(this::toModel).collect(toList());
    }

    @Override
    public Role create(Role role) {
        role.setId(UUID.randomUUID().toString());
        roleRepository.count();
        return toModel(roleRepository.save(toEntity(role)));
    }

    @Override
    public Role getRole(String roleId) {
        Integer total = userRepository.countUserEntitiesByRole(roleRepository.getById(roleId));
        System.out.println(total); // TODO: FINISH
        return toModel(roleRepository.getById(roleId));
    }

    @Override
    public Role delete(String roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Error"));
        roleRepository.delete(roleEntity);
        return toModel(roleEntity);
    }

    protected RoleEntity createAdminRole() {
        RoleEntity roleEntity = new RoleEntity("ADMIN");
        roleEntity.setId(UUID.randomUUID().toString());
        return roleRepository.save(roleEntity);
    }

    protected Role toModel(RoleEntity roleEntity) {
        return Role.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getName())
                .users(userRepository.countUserEntitiesByRole(roleRepository.getById(roleEntity.getId())))
                .createdAt(roleEntity.getCreatedAt())
                .updatedAt(roleEntity.getUpdatedAt())
                .deleted(roleEntity.isDeleted())
                .build();
    }

    protected RoleEntity toEntity(Role role) {
        return RoleEntity.builder()
                .id(role.getId())
                .name(role.getName().toUpperCase())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .deleted(role.isDeleted())
                .build();
    }
}
