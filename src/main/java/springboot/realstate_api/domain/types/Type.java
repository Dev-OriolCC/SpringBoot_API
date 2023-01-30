package springboot.realstate_api.domain.types;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Boolean deleted = false;
    private String name;
}
