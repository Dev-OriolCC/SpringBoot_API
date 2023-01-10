package springboot.realstate_api.web.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequestDto {

    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;

}
