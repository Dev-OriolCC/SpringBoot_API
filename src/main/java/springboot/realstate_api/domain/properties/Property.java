package springboot.realstate_api.domain.properties;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property extends BaseModel {

    @Builder
    public Property(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String title, Float price, String description, String details, Integer squarefeet, Integer baths, Integer beds, Character state, LocalDate date_published, Integer year_built) {
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
}
