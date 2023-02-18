package springboot.realstate_api.web.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class RoleDto extends BaseDto {

    @Builder
    public RoleDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, Integer users) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.users = users;
    }

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters.")
    @Size(max = 10, message = "Name must be smaller than 10 characters.")
    private String name;

    private Integer users = 0;

}
