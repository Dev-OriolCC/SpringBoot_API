package springboot.realstate_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Type {

    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String name;

    // Relationship

}
