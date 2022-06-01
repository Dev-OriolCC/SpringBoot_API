package springboot.realstate_api.dto.requestDto;

import lombok.Data;
import springboot.realstate_api.model.Property;
import java.util.Set;

@Data
public class PhotoRequestDto {

    private String url;
    private String alt;
    private String propertyId;
    //private Set<Property> properties;
}
