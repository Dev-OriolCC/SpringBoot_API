package springboot.realstate_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Photo {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

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

    @NotNull
    @JsonIgnore
    @ManyToMany(mappedBy = "photos")
    private Set<Property> properties = new HashSet<>();

    public Set<Property> getProperties() {
        return properties;
    }
    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }
}
