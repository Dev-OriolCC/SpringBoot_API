package springboot.realstate_api.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.realstate_api.data.entities.UserEntity;
import springboot.realstate_api.data.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceAuth implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public UserServiceAuth(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Get user from database
        Optional<UserEntity> userModel =  userRepository.findByEmail(userName);
        String userEmail =  userModel.get().getEmail(); //String.valueOf(User.builder().username(userModel.getEmail()));
        String password = userModel.get().getPassword(); //String.valueOf(User.builder().password(userModel.getPassword()));
        //
        return new User(userEmail, password, new ArrayList<>());
    }
}
