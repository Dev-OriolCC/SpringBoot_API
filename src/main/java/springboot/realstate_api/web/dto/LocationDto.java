package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
//@SuperBuilder
public class LocationDto extends BaseDto {

    @Builder
    public LocationDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String country, String state, String city, Integer zipcode, String street, String avenue) {
        super(id, updatedAt, createdAt, deleted);
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.avenue = avenue;
    }

    @NotNull
    @Size(min = 4, message = "Country must be at least 4 characters")
    private String country;
    @NotNull
    @Size(min = 4, message = "State must be at least 4 characters")
    private String state;

    @NotNull
    @Size(min = 4, message = "City must be at least 4 characters")
    private String city;

    @NotNull
    @Min(1000)
    @Max(10000000)
    private Integer zipcode;

    @Size(min = 4, message = "Street must be at least 4 characters")
    private String street;
    @Size(min = 4, message = "Street must be at least 4 characters")
    private String avenue;


}
