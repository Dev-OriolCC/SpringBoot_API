package springboot.realstate_api.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LocationRequestDto {

    @NotNull
    @Size(min = 4, message = "Country must at least be greater than 4 characters")
    private String country;

    @NotNull
    @Size(min = 4, message = "State must at least be greater than 4 characters")
    private String state;

    @NotNull
    @Size(min = 4, message = "City must at least be greater than 4 characters")
    private String city;

    @NotNull
    @Min(4)
    @Max(8)
    private Integer zipcode;

    @Min(value = 4, message = "Street must at least be greater than 4 characters")
    private String street;

    @Min(value = 4, message = "Street must at least be greater than 4 characters")
    private String avenue;

}
