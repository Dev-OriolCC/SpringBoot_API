package springboot.realstate_api.domain.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.realstate_api.domain.base.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseModel {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String contact_email;
    private String twitter;
    private Long mobile;

    // Relationships...
}
