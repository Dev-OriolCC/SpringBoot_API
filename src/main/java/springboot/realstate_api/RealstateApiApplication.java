package springboot.realstate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"springboot.realstate_api.model", "springboot.realstate_api.repository"})
// Upload Image files
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class RealstateApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealstateApiApplication.class, args);
	}
	/* Notes to improve
	*
	 */
}
