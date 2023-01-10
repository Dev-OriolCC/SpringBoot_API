package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.domain.features.Feature;
import springboot.realstate_api.domain.features.FeatureGateway;
import springboot.realstate_api.web.dto.requestDto.FeatureRequestDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultFeatureGateway implements FeatureGateway {
    @Override
    public List<FeatureRequestDto> getFeatures() {
        return null;
    }

    @Override
    public FeatureRequestDto addFeature(Feature feature) {
        return null;
    }

    @Override
    public FeatureRequestDto getFeature(String featureId) {
        return null;
    }

    @Override
    public FeatureRequestDto deleteFeature(String featureId) {
        return null;
    }
}
