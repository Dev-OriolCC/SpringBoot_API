package springboot.realstate_api.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    // This is how to disable CSRF Protection
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //config to permit all the requests
        http.csrf().disable();
    }

//    @Override
//    protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("ADMIN");
//    }

}
