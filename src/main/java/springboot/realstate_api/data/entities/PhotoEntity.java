package springboot.realstate_api.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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
    @Builder
    public PhotoEntity(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String url, String name, String fileType, Long size, Set<PropertyEntity> properties) {
        super(id, updatedAt, createdAt, deleted);
        this.url = url;
        this.name = name;
        this.fileType = fileType;
        this.size = size;
        this.properties = properties;
    }

    //    @NotNull
//    @Pattern(message = "URL not valid", regexp = "https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,}")
//    @Size(min = 4, message = "URL must at least be greater than 4 characters")
    private String url;

    private String name;

    private String fileType;

    private Long size;

    // Relationship
    @ManyToMany(mappedBy = "photos")
    private Set<PropertyEntity> properties = new HashSet<>();

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
