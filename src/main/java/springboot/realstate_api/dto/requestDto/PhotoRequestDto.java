package springboot.realstate_api.dto.requestDto;

import lombok.Data;


@Data
public class PhotoRequestDto {

    private String url;
    private String alt;
    private String propertyId;
    //private Set<Property> properties;
}
