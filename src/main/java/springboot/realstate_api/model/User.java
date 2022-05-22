package springboot.realstate_api.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class User {

    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String name;
    private String lastname;
    private String email;
    private String password;
    private String contact_email;
    private String twitter;
    private Long mobile;

    // Relationship
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Role role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
    private Location location;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Property> properties;

    // Getters and Setters
}
