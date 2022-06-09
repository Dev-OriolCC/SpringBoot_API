package springboot.realstate_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Property {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

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
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Type.class)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Type type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private User user;

    @ManyToMany()
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "property_feature",
        joinColumns = @JoinColumn(name = "property_id"),
        inverseJoinColumns = @JoinColumn(name = "feature_id")
    ) // Previously didn't have & Feature only had id
    private Set<Feature> features = new HashSet<>();

    public Set<Feature> getFeatures() {
        return features;
    }
    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    @ManyToMany()
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "property_photo",
        joinColumns = @JoinColumn(name = "property_id"),
        inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private Set<Photo> photos = new HashSet<>();

    public Set<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

}
