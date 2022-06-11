package springboot.realstate_api.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class PhotoRequestDto {

    private String url;
    private String name;
    private String propertyId;
    private String fileType;
    private Long size;
    //private Set<Property> properties;
}
