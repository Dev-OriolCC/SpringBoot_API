package springboot.realstate_api.web;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.roles.Role;
import springboot.realstate_api.domain.roles.RoleService;
import springboot.realstate_api.web.dto.RoleDto;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {


    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDto>> getRoles() {
        List<RoleDto> roleDtoList = roleService.getRoles().stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(roleDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@Valid @RequestBody RoleDto roleDto) {
        return new ResponseEntity<>(toDto(roleService.create(toModel(roleDto))), HttpStatus.CREATED);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleDto> getRole(@PathVariable String id) {
        return new ResponseEntity<>(toDto(roleService.getRole(id)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public Role toModel(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .createdAt(roleDto.getCreatedAt())
                .updatedAt(roleDto.getUpdatedAt())
                .deleted(roleDto.isDeleted())
                .build();
    }

    public RoleDto toDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .deleted(role.isDeleted())
                .build();
    }


}
