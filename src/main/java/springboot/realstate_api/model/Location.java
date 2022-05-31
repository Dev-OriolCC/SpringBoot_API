package springboot.realstate_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Location {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

    @NotNull
    @Size(min = 4, message = "Country must at least be greater than 4 characters")
    private String country;

    @NotNull
    @Size(min = 4, message = "State must at least be greater than 4 characters")
    private String state;

    @NotNull
    @Size(min = 4, message = "City must at least be greater than 4 characters")
    private String city;

    @NotNull
    @Min(1000)
    @Max(10000000)
    private Integer zipcode;

    @Size(min = 4, message = "Street must at least be greater than 4 characters")
    private String street;

    @Size(min = 4, message = "Street must at least be greater than 4 characters")
    private String avenue;

    // Relationship


    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }
}
