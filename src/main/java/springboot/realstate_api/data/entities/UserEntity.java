package springboot.realstate_api.data.entities;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class UserEntity extends BaseEntity {

    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */

    @Builder
    public UserEntity(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, String lastName, String email, String password, String contact_email, String twitter, Long mobile, RoleEntity role, LocationEntity location) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contact_email = contact_email;
        this.twitter = twitter;
        this.mobile = mobile;
        this.role = role;
        this.location = location;
    }

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
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true) // false
    private RoleEntity role;


    //TODO: Location
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = LocationEntity.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
    private LocationEntity location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(name, that.name)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(email, that.email)
                && Objects.equals(password, that.password)
                && Objects.equals(contact_email, that.contact_email)
                && Objects.equals(twitter, that.twitter)
                && Objects.equals(mobile, that.mobile)
                && Objects.equals(getUpdatedAt(), that.getUpdatedAt())
                && Objects.equals(getCreatedAt(), that.getCreatedAt())
                && Objects.equals(isDeleted(), that.isDeleted());

    }

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
