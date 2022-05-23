package springboot.realstate_api.dto.responseDto;

import lombok.Data;
import springboot.realstate_api.dto.requestDto.LocationRequestDto;
import springboot.realstate_api.dto.requestDto.RoleRequestDto;
import springboot.realstate_api.dto.requestDto.TypeRequestDto;

import java.util.Set;

@Data
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
