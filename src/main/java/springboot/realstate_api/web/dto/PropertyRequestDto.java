package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PropertyRequestDto extends BaseDto {

    @Builder
    public PropertyRequestDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String title, Float price, String description, String details, Integer squarefeet, Integer baths, Integer beds, Character state, LocalDate date_published, Integer year_built, String propertyTypeId, String propertyLocationId, String propertyUserId) {
        super(id, updatedAt, createdAt, deleted);
        this.title = title;
        this.price = price;
        this.description = description;
        this.details = details;
        this.squarefeet = squarefeet;
        this.baths = baths;
        this.beds = beds;
        this.state = state;
        this.date_published = date_published;
        this.year_built = year_built;
        this.propertyTypeId = propertyTypeId;
        this.propertyLocationId = propertyLocationId;
        this.propertyUserId = propertyUserId;
    }

    @NotNull
    @Size(min = 4, message = "Title must be at least 4 characters")
    private String title;

    @NotNull
    @Min(value = 4, message = "Price should be higher")
    @Max(12)
    private Float price;

    @NotNull
    @Size(min = 10, message = "Description must be at least 10 characters")
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
