package springboot.realstate_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springboot.realstate_api.filter.JwtFilter;
import springboot.realstate_api.service.UserServiceAuth;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    @Autowired
    private UserServiceAuth userServiceAuth;
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userServiceAuth);
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
                .antMatchers("/authenticate", "/swagger-ui/index.html#")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // I think so
    }



//    @Override
//    protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("ADMIN");
//    }

}
