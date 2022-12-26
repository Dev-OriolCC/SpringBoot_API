package springboot.realstate_api.domain.features;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.FeatureRequestDto;

import java.util.List;

@Service
public interface FeatureService {
    //
    public List<FeatureRequestDto> getFeatures();
    public FeatureRequestDto addFeature(FeatureRequestDto featureRequestDto);
    public FeatureRequestDto getFeature(String featureId);
    public FeatureRequestDto deleteFeature(String featureId);
}
