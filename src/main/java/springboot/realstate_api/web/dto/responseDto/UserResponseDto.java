package springboot.realstate_api.web.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import springboot.realstate_api.web.dto.requestDto.LocationRequestDto;
import springboot.realstate_api.web.dto.requestDto.RoleRequestDto;

import java.util.Set;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String lastname;
    private String email;
    private String contact_email;
    private String twitter;
    private Long mobile;
    // Relational data
    private RoleRequestDto role;
    private LocationRequestDto location;
    private Integer numberProperties;
    private Set<PropertyResponseDto> properties; // TEST

}
