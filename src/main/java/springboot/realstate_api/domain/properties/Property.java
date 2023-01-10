package springboot.realstate_api.domain.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Property extends BaseModel {
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
