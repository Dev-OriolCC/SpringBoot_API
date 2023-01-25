package springboot.realstate_api.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class LocationDto extends BaseDto {

    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;

}
