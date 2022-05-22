package springboot.realstate_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Location {

    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String country;
    private String state;
    private String city;
    private Integer zipcode;
    private String street;
    private String avenue;

    // Relationship
}
