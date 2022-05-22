package springboot.realstate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.demo.model") // For relationships
public class RealstateApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(RealstateApiApplication.class, args);


	}


}
