package springboot.realstate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springboot.realstate_api.property.FileStorageProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableJpaRepositories(basePackages = {"springboot.realstate_api.model", "springboot.realstate_api.repository"})
//@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
//@EnableSwagger2
@EnableConfigurationProperties({
		FileStorageProperties.class
})
@SpringBootApplication
public class RealstateApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealstateApiApplication.class, args);
	}

	/* Notes to improve
	* Create auth folder with logic
	* Fix mappers
	* Separate service logic
	* fix relationships
	 */
}

