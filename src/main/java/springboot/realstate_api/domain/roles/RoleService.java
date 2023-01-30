package springboot.realstate_api.domain.roles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleGateway roleGateway;

    public List<Role> getRoles() {
        return roleGateway.getRoles();
    }

    public Role create(Role role) { return roleGateway.create(role); }

    public Role getRole(String roleId) {
        return roleGateway.getRole(roleId);
    }

    public Role delete(String roleId) {
        return roleGateway.delete(roleId);
    }
}
