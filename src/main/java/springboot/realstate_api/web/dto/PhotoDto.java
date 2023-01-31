package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
//@SuperBuilder
public class PhotoDto extends BaseDto {

    @Builder
    public PhotoDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String url, String name, String propertyId, String fileType, Long size) {
        super(id, updatedAt, createdAt, deleted);
        this.url = url;
        this.name = name;
        this.propertyId = propertyId;
        this.fileType = fileType;
        this.size = size;
    }

    private String url;
    private String name;
    private String propertyId;
    private String fileType;
    private Long size;

    //private Set<Property> properties;
}
