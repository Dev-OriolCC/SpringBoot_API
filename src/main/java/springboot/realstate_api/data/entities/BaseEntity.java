package springboot.realstate_api.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//@AllArgsConstructor
@Getter
@Setter
//@SuperBuilder
@MappedSuperclass
//@MappedSuperclass
//@EntityListeners({AuditingEntityListener.class})
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    // This is a test....
    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "created_at", updatable = false, insertable = true) // changed to true...
    @CreationTimestamp
    private LocalDateTime createdAt;

    private boolean deleted = false;
}
