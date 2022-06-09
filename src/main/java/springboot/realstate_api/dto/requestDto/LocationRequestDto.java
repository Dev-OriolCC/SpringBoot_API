package springboot.realstate_api.dto.requestDto;

import lombok.Data;

@Data
public class LocationRequestDto {

    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;

}
