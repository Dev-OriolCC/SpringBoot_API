package springboot.realstate_api.web.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.users.UserGateway;
import springboot.realstate_api.domain.users.UserServiceAuth;
import springboot.realstate_api.web.UserController;
import springboot.realstate_api.web.dto.UserRequestDto;
import springboot.realstate_api.web.dto.UserResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
//@SecurityRequirement(name = "bearerAuth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserServiceAuth userServiceAuth;
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private UserController userController;
    private final UserGateway userService;

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponseDTO>login(@Valid @RequestBody UserAuthDTO userAuthDto) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userAuthDto.email, userAuthDto.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserRequestDto user = userController.toDtoUser(userServiceAuth.findByEmail(userAuthDto.email));
        UserDetails userDetails = userServiceAuth.loadUserByUsername(user.getEmail());
        String jwtToken = jwtUtility.generateToken(userDetails);

        return new ResponseEntity<>(new UserAuthResponseDTO(jwtToken), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody final UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userController.toDto(userService.create(userController.toModel(userRequestDto))), HttpStatus.CREATED);
    }


    // Authenticate METHOD
    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userServiceAuth.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }

    // DTOs
    @Getter
    @Setter
    @Builder
    public static class UserAuthResponseDTO {
        private String jwt;
    }

    @Setter
    @Getter
    @Builder
    public static class UserAuthDTO {
        @NotNull
        private String email;
        @NotNull
        private String password;
    }

}
