package springboot.realstate_api.web.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class PhotoRequestDto {

    private String url;
    private String name;
    private String propertyId;
    private String fileType;
    private Long size;
    //private Set<Property> properties;
}
