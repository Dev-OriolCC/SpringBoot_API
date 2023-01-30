package springboot.realstate_api.domain.types;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeService {

    private final TypeGateway typeGateway;

    public List<Type> getTypes() {
        return typeGateway.getTypes();
    }

    public Type create(Type type) {
        return typeGateway.create(type);
    }

    public Type getType(String typeId) {
        return typeGateway.getType(typeId);
    }

    public Type delete(String typeId) {
        return typeGateway.delete(typeId);
    }
}
