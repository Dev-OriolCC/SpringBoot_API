package springboot.realstate_api.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Feature {
    // Change length to 36 & all occurrences
    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;

    // Relationship
    @JsonIgnore
    @ManyToMany(mappedBy = "features")
    private Set<Property> properties = new HashSet<>();

    public Set<Property> getProperties() {
        return properties;
    }
    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
