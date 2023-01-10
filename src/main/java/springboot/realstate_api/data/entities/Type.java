package springboot.realstate_api.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "types")
@SQLDelete(sql = "UPDATE types SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Type extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */

    private String name;

}
