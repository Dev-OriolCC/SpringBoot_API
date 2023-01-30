package springboot.realstate_api.data.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class UserEntity extends BaseEntity {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String contact_email;
    private String twitter;
    private Long mobile;

    // Relationship
    //TODO: Role
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = RoleEntity.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity role;


    //TODO: Location
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = LocationEntity.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
    private LocationEntity location;



//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = RoleEntity.class)
//    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private RoleEntity role;
//
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = LocationEntity.class)
//    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
//    private LocationEntity location;

//    @OneToMany(mappedBy = "user")
//    @JsonIgnore
//    private Set<PropertyEntity> properties;
    // Properties

    // Getters and Setters

//    public RoleEntity getRole() {
//        return role;
//    }
//    public void setRole(RoleEntity role) {
//        this.role = role;
//    }
//
//    public LocationEntity getLocation() {
//        return location;
//    }
//    public void setLocation(LocationEntity location) {
//        this.location = location;
//    }

//    public Set<PropertyEntity> getProperties() {
//        return properties;
//    }
//    public void setProperties(Set<PropertyEntity> properties) {
//        this.properties = properties;
//    }
}
