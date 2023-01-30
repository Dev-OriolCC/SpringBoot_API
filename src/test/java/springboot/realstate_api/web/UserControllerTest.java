package springboot.realstate_api.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import springboot.realstate_api.data.entities.LocationEntity;
import springboot.realstate_api.data.entities.RoleEntity;
import springboot.realstate_api.data.entities.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import springboot.realstate_api.data.repositories.RoleRepository;
import springboot.realstate_api.web.dto.UserRequestDto;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private RoleRepository roleRepository;

    private String url = "http://localhost:8080/users";

    @Test
    void getUsers() throws Exception {
        mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addUser() throws Exception {
        RoleEntity roleEntity = createRoleEntity("201", "Admin");
        //roleRepository.save(roleEntity);
        roleEntity.getId();
        roleEntity.getCreatedAt();
        when(roleRepository.save(roleEntity)).thenReturn(roleEntity);

//        LocationEntity locationEntity = new LocationEntity("Mexico", "DF", "CDMX", 77880, "12", "9A");
//        UserEntity userEntity = createUserEntity("0391-2921", "Walter", "White", "walter@gmail.com", roleEntity, locationEntity);
//
//        UserRequestDto userRequestDto = createUserDto("0391-2921", "Walter", "White", "walter@gmail.com", roleEntity.getId());
//
//
//        mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(String.valueOf(userRequestDto)))
//                .andExpect(status().isCreated());
    }

    @Test
    void deleteUser() {
    }

    @Test
    void addRole() {
    }

    @Test
    void addLocation() {
    }


    private UserEntity createUserEntity(String id, String name, String lastName, String email, RoleEntity role, LocationEntity location) {
        return UserEntity.builder().id(id).name(name).lastName(lastName).email(email).role(role).location(location).build();
    }

    private RoleEntity createRoleEntity(String id, String name) {
        return RoleEntity.builder().name(name).build();
    }

    private UserRequestDto createUserDto(String id, String name, String lastName, String email, String role) {
        return UserRequestDto.builder().id(id).name(name).lastname(lastName).email(email).roleId(role).build();
    }

}