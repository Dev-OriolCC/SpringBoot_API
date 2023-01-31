package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
//@SuperBuilder
public class UserResponseDto extends BaseDto {

    @Builder
    public UserResponseDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, String lastname, String email, String contact_email, String twitter, Long mobile, RoleDto role, LocationDto location, Integer numberProperties, Set<PropertyResponseDto> properties) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.contact_email = contact_email;
        this.twitter = twitter;
        this.mobile = mobile;
        this.role = role;
        this.location = location;
        this.numberProperties = numberProperties;
        this.properties = properties;
    }

    private String name;
    private String lastname;
    private String email;
    private String contact_email;
    private String twitter;
    private Long mobile;
    // Relational data
    private RoleDto role;
    private LocationDto location;
    private Integer numberProperties;
    private Set<PropertyResponseDto> properties; // TEST

}
