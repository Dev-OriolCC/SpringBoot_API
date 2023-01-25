package springboot.realstate_api.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
public class BaseDto {
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Boolean deleted; // test I changed to static 2 remove warning...
}
