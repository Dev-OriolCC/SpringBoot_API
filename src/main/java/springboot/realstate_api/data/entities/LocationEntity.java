package springboot.realstate_api.data.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "locations")
@SQLDelete(sql = "UPDATE locations SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class LocationEntity extends BaseEntity {

    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */
    @Builder
    public LocationEntity(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String country, String state, String city, Integer zipcode, String street, String avenue) {
        super(id, updatedAt, createdAt, deleted);
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.avenue = avenue;
    }

    private String country;

    private String state;

    private String city;

    private Integer zipcode;

    private String street;

    private String avenue;

    // Relationship

}
