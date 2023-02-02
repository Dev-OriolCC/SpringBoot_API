package springboot.realstate_api.data.gateways;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.entities.TypeEntity;
import springboot.realstate_api.data.repositories.TypeRepository;
import springboot.realstate_api.domain.roles.Role;
import springboot.realstate_api.domain.types.Type;
import springboot.realstate_api.domain.types.TypeGateway;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DefaultTypeGateway implements TypeGateway {

    private final TypeRepository typeRepository;
    @Override
    public List<Type> getTypes() {
        return typeRepository.findAll().stream().map(this::toModel).collect(toList());
    }

    @Override
    public Type create(Type type) {
        type.setId(UUID.randomUUID().toString());
        return toModel(typeRepository.save(toEntity(type)));
    }

    @Override
    public Type getType(String typeId) {
        return null;
    }

    @Override
    public Type delete(String typeId) {
        return null;
    }

    private Type toModel(TypeEntity typeEntity) {
        return Type.builder()
                .id(typeEntity.getId())
                .name(typeEntity.getName())
                .createdAt(typeEntity.getCreatedAt())
                .updatedAt(typeEntity.getUpdatedAt())
                .deleted(typeEntity.isDeleted())
                .build();
    }

    private TypeEntity toEntity(Type type) {
        return TypeEntity.builder()
                .id(type.getId())
                .name(type.getName())
                .createdAt(type.getCreatedAt())
                .updatedAt(type.getUpdatedAt())
                .deleted(type.isDeleted())
                .build();
    }

}
