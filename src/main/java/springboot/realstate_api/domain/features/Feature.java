package springboot.realstate_api.domain.features;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature extends BaseModel {

    @Builder
    public Feature(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

    private String name;
}
