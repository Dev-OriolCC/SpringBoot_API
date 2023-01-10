package springboot.realstate_api.domain.features;

import springboot.realstate_api.web.dto.requestDto.FeatureRequestDto;

import java.util.List;

public interface FeatureGateway {
    //
    List<FeatureRequestDto> getFeatures();
    FeatureRequestDto addFeature(Feature feature);
    FeatureRequestDto getFeature(String featureId);
    FeatureRequestDto deleteFeature(String featureId);
}
