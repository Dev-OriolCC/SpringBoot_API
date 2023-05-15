package springboot.realstate_api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.realstate_api.domain.roles.RoleService;
import springboot.realstate_api.web.RoleController;
import springboot.realstate_api.web.RoleControllerTest;

@SpringBootTest
class RealstateApiApplicationTests {

	@Test
	void contextLoads() {

		SpringApplication.run(RoleControllerTest.class);
	}

}
