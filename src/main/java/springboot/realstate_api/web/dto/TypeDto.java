package springboot.realstate_api.web.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
//@SuperBuilder
public class TypeDto extends BaseDto {
    @Builder
    public TypeDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, Boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;

}
