package springboot.realstate_api.domain.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseModel {
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Boolean deleted = false;

}
