package springboot.realstate_api.web;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.types.Type;
import springboot.realstate_api.domain.types.TypeService;
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

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> getType(@PathVariable String id) {
        return new ResponseEntity<>(toDto(typeService.getType(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public Type toModel(TypeDto typeDto) {
        return Type.builder()
                .id(typeDto.getId())
                .name(typeDto.getName())
                .createdAt(typeDto.getCreatedAt())
                .updatedAt(typeDto.getUpdatedAt())
                .deleted(typeDto.isDeleted())
                .build();
    }

    public TypeDto toDto(Type type) {
        return TypeDto.builder()
                .id(type.getId())
                .name(type.getName())
                .createdAt(type.getCreatedAt())
                .updatedAt(type.getUpdatedAt())
                .deleted(type.isDeleted())
                .build();
    }
}
