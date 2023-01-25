package springboot.realstate_api.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.realstate_api.data.entities.FeatureEntity;
import springboot.realstate_api.data.entities.PhotoEntity;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class PropertyResponseDto extends BaseDto {
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
