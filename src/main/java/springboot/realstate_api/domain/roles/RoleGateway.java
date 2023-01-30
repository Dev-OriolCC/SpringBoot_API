package springboot.realstate_api.domain.roles;
import java.util.List;

public interface RoleGateway {

    List<Role> getRoles();
    Role create(Role role);
    Role getRole(String roleId);
    Role delete(String roleId);
}
