package springboot.realstate_api.domain.locations;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseModel {

    @Builder
    public Location(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String country, String state, String city, Integer zipcode, String street, String avenue) {
        super(id, updatedAt, createdAt, deleted);
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.avenue = avenue;
    }

    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;
}
