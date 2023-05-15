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
    public TypeDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, Integer total) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.total = total;
    }

    @NotNull
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;

    private Integer total;

}
