package springboot.realstate_api.domain.types;


import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Type extends BaseModel {

    @Builder
    public Type(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, Integer total) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.total = total;
    }

    private String name;
    private Integer total;
}
