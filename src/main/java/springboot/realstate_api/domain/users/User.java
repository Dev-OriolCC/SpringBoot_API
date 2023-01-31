package springboot.realstate_api.domain.users;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel {

    @Builder
    public User(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, String lastName, String email, String password, String contact_email, String twitter, Long mobile) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contact_email = contact_email;
        this.twitter = twitter;
        this.mobile = mobile;
    }

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String contact_email;
    private String twitter;
    private Long mobile;

    // Relationships...
}
