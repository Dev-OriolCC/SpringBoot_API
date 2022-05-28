package springboot.realstate_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;



@Entity
public class Feature {
    // Change length to 36 & all occurrences
    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

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
