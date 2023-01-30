package springboot.realstate_api.domain.types;

import springboot.realstate_api.domain.roles.Role;

import java.util.List;

public interface TypeGateway {
    List<Type> getTypes();
    Type create(Type type);
    Type getType(String typeId);
    Type delete(String typeId);

}
