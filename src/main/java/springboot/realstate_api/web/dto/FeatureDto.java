package springboot.realstate_api.web.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
//@SuperBuilder
public class FeatureDto extends BaseDto {

    @Builder
    public FeatureDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

    private String name;

}
