package springboot.realstate_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.realstate_api.repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserServiceAuth implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceAuth(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Get user from database
        springboot.realstate_api.model.User userModel =  userRepository.findByEmail(userName);
        String userEmail =  userModel.getEmail(); //String.valueOf(User.builder().username(userModel.getEmail()));
        String password = userModel.getPassword(); //String.valueOf(User.builder().password(userModel.getPassword()));
        //
        return new User(userEmail, password, new ArrayList<>());
    }
}
