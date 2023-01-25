package springboot.realstate_api.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "photos")
@SQLDelete(sql = "UPDATE photos SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class PhotoEntity extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */

//    @NotNull
//    @Pattern(message = "URL not valid", regexp = "https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,}")
//    @Size(min = 4, message = "URL must at least be greater than 4 characters")
    private String url;

    @NotNull
    @Size(min = 4, message = "ALT must at least be greater than 4 characters")
    private String name;

    @NotNull
    private String fileType;

    @NotNull
    private Long size;

    // Relationship

//    @NotNull
//    @JsonIgnore
//    @ManyToMany(mappedBy = "photos")
//    private Set<Property> properties = new HashSet<>();
//
//    public Set<Property> getProperties() {
//        return properties;
//    }
//    public void setProperties(Set<Property> properties) {
//        this.properties = properties;
//    }
}
