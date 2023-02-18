package springboot.realstate_api.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.repositories.RoleRepository;
import springboot.realstate_api.web.dto.RoleDto;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public
class RoleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private RoleRepository roleRepository;

    private String uri = "http://localhost:8080/roles";

    @Test
    void getRoles() throws Exception {
        mockMvc.perform(get(uri)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        RoleEntity roleEntity = new RoleEntity("100-000");
        //RoleEntity roleEntitySaved = new RoleEntity();

        when(roleRepository.save(roleEntity)).thenReturn(roleEntity);

        RoleDto roleDto = new RoleDto("100-000-2222", LocalDateTime.now(), LocalDateTime.now(), false, "Admins");

        mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(roleDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void getRole() {
    }

    @Test
    void delete() {
    }

    @Test
    void toModel() {
    }

    @Test
    void toDto() {
    }
}