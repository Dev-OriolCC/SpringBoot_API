package springboot.realstate_api.web.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TypeRequestDto {

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;

}
