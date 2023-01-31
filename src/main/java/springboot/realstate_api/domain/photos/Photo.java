package springboot.realstate_api.domain.photos;

import lombok.*;
import springboot.realstate_api.domain.base.BaseModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photo extends BaseModel {

    @Builder
    public Photo(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String url, String name, String fileType, Long size) {
        super(id, updatedAt, createdAt, deleted);
        this.url = url;
        this.name = name;
        this.fileType = fileType;
        this.size = size;
    }

    private String url;
    private String name;
    private String fileType;
    private Long size;

}
