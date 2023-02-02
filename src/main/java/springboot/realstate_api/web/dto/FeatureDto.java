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
public class FeatureDto extends BaseDto {

    @Builder
    public FeatureDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

    @NotNull
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;

}
