package springboot.realstate_api.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
public class PhotoDto extends BaseDto {

    private String url;
    private String name;
    private String propertyId;
    private String fileType;
    private Long size;
    //private Set<Property> properties;
}
