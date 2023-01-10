package springboot.realstate_api.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "locations")
@SQLDelete(sql = "UPDATE locations SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Location extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */

    @NotNull
    @Size(min = 4, message = "Country must at least be greater than 4 characters")
    private String country;

    @NotNull
    @Size(min = 4, message = "State must at least be greater than 4 characters")
    private String state;

    @NotNull
    @Size(min = 4, message = "City must at least be greater than 4 characters")
    private String city;

    @NotNull
    @Min(1000)
    @Max(10000000)
    private Integer zipcode;

    @Size(min = 4, message = "Street must at least be greater than 4 characters")
    private String street;

    @Size(min = 4, message = "Street must at least be greater than 4 characters")
    private String avenue;

    // Relationship

}
