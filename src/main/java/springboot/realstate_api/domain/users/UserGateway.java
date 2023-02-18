package springboot.realstate_api.domain.users;


import java.util.List;

public interface UserGateway {

    List<User> getUsers();
    User create(User User);
    User delete(String userId);
    User editUser(User user, String userId);
    // Relational Data
    User addRoleToUser(String roleId, String userId);
    User addLocationToUser(String locationId, String userId);

    User findByEmail(String email);
}
