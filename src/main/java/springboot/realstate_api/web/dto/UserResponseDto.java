package springboot.realstate_api.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class UserResponseDto extends BaseDto {
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
