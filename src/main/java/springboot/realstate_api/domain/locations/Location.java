package springboot.realstate_api.domain.locations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.realstate_api.domain.base.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Location extends BaseModel {
    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;
}
