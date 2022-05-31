package springboot.realstate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
 @EnableJpaRepositories(basePackages = {"springboot.realstate_api.model", "springboot.realstate_api.repository"})
//@EnableJpaRepositories("com.example.realstate_api.repository")
//@EnableJpaRepositories("springboot.realstate_api.repository")
//@EntityScan("com.example.realstate_api.model") // For relationships [demo] removed after example
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class RealstateApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealstateApiApplication.class, args);
	}
	/* Notes to improve
	 * Add user Role & Location
	 * Fix photo controller issues/nonsense
	 * Add relational data
	 * Check if some DTO responses can be fixed
	 */
}
