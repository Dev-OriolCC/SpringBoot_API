package springboot.realstate_api.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LocationRequestDto {

    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;

}
