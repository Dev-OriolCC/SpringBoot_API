package springboot.realstate_api.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "properties")
@SQLDelete(sql = "UPDATE properties SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class PropertyEntity extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */

    private String title;
    private Float price;
    private String description;
    private String details;
    private Integer squarefeet;
    private Integer baths;
    private Integer beds;
    private Character state;
    private LocalDate date_published;
    private Integer year_built;


    // Relationships
    //TODO: Location
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = LocationEntity.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private LocationEntity location;

    //TODO: Type
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = TypeEntity.class)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeEntity type;

    //TODO: User, Feature, Photo
//    @OneToMany(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
//    private UserEntity userEntity;

    //TODO: USER
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity; //TODO: Changed modified OneToMany

    @Column(name = "user_id", nullable = false)
    private String userId;


    //TODO: Feature
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "property_feature",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns =@JoinColumn(name = "feature_id")
    )
    private Set<FeatureEntity> features = new HashSet<>();

    //TODO: Photo
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "property_photo",
        joinColumns = @JoinColumn(name = "property_id"),
        inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private Set<PhotoEntity> photos = new HashSet<>();


//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Type.class)
//    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = true)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Type type;
//
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Location.class)
//    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
//    private Location location;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
//    private User user;
//
//    @ManyToMany()
//    @Fetch(value = FetchMode.SELECT)
//    @JoinTable(name = "property_feature",
//        joinColumns = @JoinColumn(name = "property_id"),
//        inverseJoinColumns = @JoinColumn(name = "feature_id")
//    ) // Previously didn't have & Feature only had id
//    private Set<Feature> features = new HashSet<>();
//
//    public Set<Feature> getFeatures() {
//        return features;
//    }
//    public void setFeatures(Set<Feature> features) {
//        this.features = features;
//    }
//
//    @ManyToMany()
//    @Fetch(value = FetchMode.SELECT)
//    @JoinTable(name = "property_photo",
//        joinColumns = @JoinColumn(name = "property_id"),
//        inverseJoinColumns = @JoinColumn(name = "photo_id")
//    )
//    private Set<Photo> photos = new HashSet<>();
//
//    public Set<Photo> getPhotos() {
//        return photos;
//    }
//    public void setPhotos(Set<Photo> photos) {
//        this.photos = photos;
//    }

}
