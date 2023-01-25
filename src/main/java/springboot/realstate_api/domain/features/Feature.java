package springboot.realstate_api.domain.features;

import lombok.*;
import lombok.experimental.SuperBuilder;
import springboot.realstate_api.domain.base.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Feature extends BaseModel {
    private String name;
}
