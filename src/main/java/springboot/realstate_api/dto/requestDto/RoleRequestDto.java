package springboot.realstate_api.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RoleRequestDto {

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;
}
