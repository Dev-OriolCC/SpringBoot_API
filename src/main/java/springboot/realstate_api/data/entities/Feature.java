package springboot.realstate_api.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "features")
@SQLDelete(sql = "UPDATE features SET deleted =true WHERE id = ?")
@Where(clause = "deleted = false")
public class Feature extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */
    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;
    // Working apparently, waiting for testing results...

//    Feature feature1 = Feature.builder()
//            .id("ID-30120302")
//            .name("Keyboard")
//            .createdAt(LocalDateTime.now())
//            .updatedAt(LocalDateTime.now())
//            .build();


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

