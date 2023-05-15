package springboot.realstate_api.data.gateways;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.TypeEntity;
import springboot.realstate_api.data.repositories.PropertyRepository;
import springboot.realstate_api.data.repositories.TypeRepository;
import springboot.realstate_api.domain.types.Type;
import springboot.realstate_api.domain.types.TypeGateway;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DefaultTypeGateway implements TypeGateway {

    private final TypeRepository typeRepository;
    private final PropertyRepository propertyRepository;
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
        TypeEntity typeEntity = typeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Error"));
        return toModel(typeEntity);
    }

    @Override
    public Type delete(String typeId) {
        TypeEntity typeEntity = typeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Error"));
        typeRepository.delete(typeEntity);
        return toModel(typeEntity);
    }


    // Protected methods
    protected TypeEntity createDefaultType() {
        TypeEntity typeEntity = new TypeEntity("House");
        typeEntity.setId(UUID.randomUUID().toString());
        return typeRepository.save(typeEntity);
    }

    protected Integer getTotalProperties(String typeId) {
        Integer total = propertyRepository.countByTypeId(typeId);
        return total;
    }

    protected Type toModel(TypeEntity typeEntity) {
        return Type.builder()
                .id(typeEntity.getId())
                .name(typeEntity.getName())
                .createdAt(typeEntity.getCreatedAt())
                .updatedAt(typeEntity.getUpdatedAt())
                .deleted(typeEntity.isDeleted())
                .total(getTotalProperties(typeEntity.getId())) //* TEST (Calypso - 2023)
                .build();
    }

    protected TypeEntity toEntity(Type type) {
        return TypeEntity.builder()
                .id(type.getId())
                .name(type.getName())
                .createdAt(type.getCreatedAt())
                .updatedAt(type.getUpdatedAt())
                .deleted(type.isDeleted())
                .build();
    }

}
