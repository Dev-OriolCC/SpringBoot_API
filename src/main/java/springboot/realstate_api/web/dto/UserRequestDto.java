package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
//@SuperBuilder
public class UserRequestDto extends BaseDto {

    @Builder
    public UserRequestDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, String lastname, String email, String password, String contact_email, String twitter, Long mobile, String roleId) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.contact_email = contact_email;
        this.twitter = twitter;
        this.mobile = mobile;
        this.roleId = roleId;
    }

    @NotNull
    @Size(min = 3, message = "Name must at least be greater than 3 characters")
    private String name;

    @NotNull
    @Size(min = 3, message = "Lastname must at least be greater than 3 characters")
    private String lastname;

    @NotNull
    @Size(min = 8, message = "Email must at least be greater than 8 characters")
    @Email
    private String email;

    @NotNull
    @Size(min = 12, message = "Password must at least be greater than 12 characters")
    private String password;

    @NotNull
    @Size(min = 8, message = "Contact Email must at least be greater than 8 characters")
    @Email
    private String contact_email;

    @Size(min = 5, message = "Twitter @Username must at least be greater than 5 characters")
    private String twitter;

    @Min(100000000) // Maybe change for 1_000_000_000
    private Long mobile;

    // No relationships for now
    private String roleId;

}
