package springboot.realstate_api.domain.photos;

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
public class Photo extends BaseModel {
    private String url;
    private String name;
    private String fileType;
    private Long size;

}
