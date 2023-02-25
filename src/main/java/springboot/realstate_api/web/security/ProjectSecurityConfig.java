package springboot.realstate_api.web.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springboot.realstate_api.domain.users.UserGateway;
import springboot.realstate_api.domain.users.UserServiceAuth;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter  { //implements ApplicationContextAware

    @Autowired
    private  UserServiceAuth userServiceAuth;
    @Autowired
    private  JwtFilter jwtFilter;
//    @Autowired
    //private  UserGateway userService;
    @Autowired
    private  UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceAuth);
        //auth.userDetailsService(userServiceAuth).passwordEncoder(passwordEncoder());
        //auth.authenticationProvider(authProvider());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    // This is how to disable CSRF Protection
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //config to permit all the requests
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login/authenticate", "/swagger-ui/index.html#", "/users", "/roles", "/types", "/auth/login"
                ,"/**", "/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // I think so
    }

    // Hashing passwords
    @Bean
    public AuthenticationProvider authProvider() {
        //TODO: HERE_ERROR
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService); //?
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }


//    @Override
//    protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("ADMIN");
//    }

}
