package springboot.realstate_api.data.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "features")
@SQLDelete(sql = "UPDATE features SET deleted =true WHERE id = ?")
@Where(clause = "deleted = false")
public class FeatureEntity extends BaseEntity {

    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */
    @Builder
    public FeatureEntity(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;
    //TODO: Make relationships
    // Working apparently, waiting for testing results...
    // Many to Many with properties

    // Relationship
//    @JsonIgnore
//    @ManyToMany(mappedBy = "features")
//    private Set<Property> properties = new HashSet<>();


//    public Set<Property> getProperties() {
//        return properties;
//    }
//    public void setProperties(Set<Property> properties) {
//        this.properties = properties;
//    }

}

