package springboot.realstate_api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    private String url;
    @NotNull
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;
    private String propertyId;

    @NotNull
    private String fileType;

    @NotNull
    private Long size;

    //private Set<Property> properties;
}
