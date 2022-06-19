package springboot.realstate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springboot.realstate_api.property.FileStorageProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"springboot.realstate_api.model", "springboot.realstate_api.repository"})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableSwagger2
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class RealstateApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealstateApiApplication.class, args);
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

	/* Notes to improve
	* Add JWT authentication
	* Change to use actual username and password from DB for auth
	* Password Hashing
	 */
}

