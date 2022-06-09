package springboot.realstate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springboot.realstate_api.property.FileStorageProperties;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"springboot.realstate_api.model", "springboot.realstate_api.repository"})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class RealstateApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealstateApiApplication.class, args);
	}

	/* Notes to improve
	* Upload Image files
	* Link Image file with table
	* Add JWT authentication
	 */
}

