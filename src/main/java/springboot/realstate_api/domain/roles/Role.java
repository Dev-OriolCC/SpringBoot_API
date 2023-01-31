package springboot.realstate_api.domain.roles;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
public class Role extends BaseModel {

    @Builder
    public Role(String id, LocalDateTime updatedAt, LocalDateTime createdAt, Boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

    private String name;

    //TODO: Making test of inheritance with ROLE....
    // Testing is pending

}
