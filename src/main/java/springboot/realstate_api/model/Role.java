package springboot.realstate_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

    private String name;

    // -- Relationship

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
