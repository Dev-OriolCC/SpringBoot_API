package springboot.realstate_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Feature {

    @Id
    @Column(name = "featureId", length = 16, unique = true, nullable = false)
    private UUID id;

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
}
