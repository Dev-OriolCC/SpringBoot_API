package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springboot.realstate_api.data.entities.FeatureEntity;
import springboot.realstate_api.data.entities.PhotoEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
//@SuperBuilder
public class PropertyResponseDto extends BaseDto {

    @Builder
    public PropertyResponseDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String title, Float price, String description, String details, Integer squarefeet, Integer baths, Integer beds, Character state, LocalDate date_published, Integer year_built, TypeDto type, LocationDto location, UserResponseDto user, Set<FeatureEntity> features, Set<PhotoEntity> photos) {
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
        this.type = type;
        this.location = location;
        this.user = user;
        this.features = features;
        this.photos = photos;
    }

    private String title;
    private Float price;
    private String description;
    private String details;
    private Integer squarefeet;
    private Integer baths;
    private Integer beds;
    private Character state;
    private LocalDate date_published;
    private Integer year_built;
    // Relational data
    private TypeDto type;
    private LocationDto location;
    private UserResponseDto user;
    private Set<FeatureEntity> features;
    private Set<PhotoEntity> photos;

}
