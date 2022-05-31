package springboot.realstate_api.dto.responseDto;

import lombok.Data;
import springboot.realstate_api.dto.requestDto.LocationRequestDto;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;
import springboot.realstate_api.dto.requestDto.TypeRequestDto;
import springboot.realstate_api.model.Feature;
import springboot.realstate_api.model.Photo;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PropertyResponseDto {
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
    private TypeRequestDto type;
    private LocationRequestDto location;
    private UserResponseDto user;
    private Set<Feature> features;
    private Set<Photo> photos;
}
