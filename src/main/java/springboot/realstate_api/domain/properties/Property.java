package springboot.realstate_api.domain.properties;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;
import springboot.realstate_api.domain.types.Type;
import springboot.realstate_api.domain.users.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property extends BaseModel {

    @Builder
    public Property(String id, LocalDateTime updatedAt, LocalDateTime createdAt,
                    boolean deleted, String title, Float price, String description,
                    String details, Integer squarefeet, Integer baths,
                    Integer beds, Character state, LocalDate date_published,
                    Integer year_built, Type type, User user) {
        super(id, updatedAt, createdAt, deleted); // Added TYPE
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
        // Relationship
        this.type = type;
        this.user = user;
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

    // Relationship
    private Type type;
    private User user;
}
