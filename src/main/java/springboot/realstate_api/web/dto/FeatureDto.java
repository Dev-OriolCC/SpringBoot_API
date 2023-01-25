package springboot.realstate_api.web.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class FeatureDto extends BaseDto {
    private String name;
}
