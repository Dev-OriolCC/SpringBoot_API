package springboot.realstate_api.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuperBuilder
public class RoleDto extends BaseDto {

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;
}
