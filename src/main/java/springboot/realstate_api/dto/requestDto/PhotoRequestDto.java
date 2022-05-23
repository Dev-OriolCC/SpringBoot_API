package springboot.realstate_api.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class PhotoRequestDto {

    @NotNull
    @Pattern(message = "URL not valid", regexp = "https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,}")
    @Size(min = 4, message = "URL must at least be greater than 4 characters")
    private String url;

    @NotNull
    @Size(min = 4, message = "ALT must at least be greater than 4 characters")
    private String alt;
}
