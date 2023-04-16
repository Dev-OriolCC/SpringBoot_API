package springboot.realstate_api.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserServiceAuth implements UserDetailsService {

    private UserRepository userRepository;
    private UserGateway userGateway;

    @Autowired
    public UserServiceAuth(UserRepository userRepository, UserGateway userGateway) {
        this.userRepository = userRepository;
        this.userGateway = userGateway;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Get user from database
        UserEntity userModel =  userRepository.findByEmail(userName);
        String userEmail =  userModel.getEmail(); //String.valueOf(User.builder().username(userModel.getEmail()));
        String password = userModel.getPassword(); //String.valueOf(User.builder().password(userModel.getPassword()));
        //
        return new User(userEmail, password, new ArrayList<>());
    }

    public springboot.realstate_api.domain.users.User findByEmail(String email) {
        return userGateway.findByEmail(email);
    }

}
