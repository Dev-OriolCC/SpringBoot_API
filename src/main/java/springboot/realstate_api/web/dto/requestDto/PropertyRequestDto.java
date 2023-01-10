package springboot.realstate_api.web.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PropertyRequestDto {

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String title;

    @NotNull
    @Min(value = 4, message = "Price should be higher")
    @Max(12)
    private Float price;

    @NotNull
    @Size(min = 10, message = "Description must at least be greater than 10 characters")
    private String description;


    private String details;

    @NotNull
    @Min(1)
    @Max(1000)
    private Integer squarefeet;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer baths;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer beds;

    @NotNull
    @Size(min = 4, message = "State must at least be greater than 4 characters")
    private Character state;


    private LocalDate date_published; // Pending

    @NotNull
    @Min(1900)
    private Integer year_built;

    // Relationship Data
    @NotNull
    private String propertyTypeId;

    @NotNull
    private String propertyLocationId;

    @NotNull
    private String propertyUserId;

}
