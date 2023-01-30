package springboot.realstate_api.web;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.roles.Role;
import springboot.realstate_api.domain.types.Type;
import springboot.realstate_api.domain.types.TypeGateway;
import springboot.realstate_api.domain.types.TypeService;
import springboot.realstate_api.web.dto.RoleDto;
import springboot.realstate_api.web.dto.TypeDto;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/types")
@AllArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeDto>> getTypes() {
        List<TypeDto> typeDtoList = typeService.getTypes().stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(typeDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeDto> create(@Valid @RequestBody TypeDto typeDto) {
        return new ResponseEntity<>(toDto(typeService.create(toModel(typeDto))), HttpStatus.CREATED);
    }

    public Type getType(String typeId) {
        return null;
    }

    public Type delete(String typeId) {
        return null;
    }

    public Type toModel(TypeDto typeDto) {
        return Type.builder()
                .id(typeDto.getId())
                .name(typeDto.getName())
                .createdAt(typeDto.getCreatedAt())
                .updatedAt(typeDto.getUpdatedAt())
                .deleted(typeDto.getDeleted())
                .build();
    }

    public TypeDto toDto(Type type) {
        return TypeDto.builder()
                .id(type.getId())
                .name(type.getName())
                .createdAt(type.getCreatedAt())
                .updatedAt(type.getUpdatedAt())
                .deleted(type.getDeleted())
                .build();
    }
}
