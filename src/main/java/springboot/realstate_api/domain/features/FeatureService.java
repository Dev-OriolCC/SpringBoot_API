package springboot.realstate_api.domain.features;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.web.dto.mapper;
import springboot.realstate_api.web.dto.requestDto.FeatureRequestDto;
import springboot.realstate_api.data.entities.Feature;
import springboot.realstate_api.data.repositories.FeatureRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FeatureService {

    private final FeatureRepository featureRepository;
    private final FeatureGateway featureGateway;

    public List<FeatureRequestDto> getFeatures() {
        List<Feature> featureList = featureRepository.findAll();
        return mapper.featureToFeatureRequestDtos(featureList);
    }

    public FeatureRequestDto addFeature(springboot.realstate_api.domain.features.Feature feature) {
        springboot.realstate_api.domain.features.Feature feature1 = new springboot.realstate_api.domain.features.Feature();


        return this.featureGateway.addFeature(feature);
//        Feature feature = new Feature();
//        feature.setName(featureRequestDto.getName());
//        feature.setId(UUID.randomUUID().toString());
//        featureRepository.save(feature);
//        return mapper.featureToFeatureRequestDto(feature);
    }

    public FeatureRequestDto getFeature(String featureId) {
        return mapper.featureToFeatureRequestDto(getFeatureMethod(featureId));
    }

    public FeatureRequestDto deleteFeature(String featureId) {
        Feature feature = getFeatureMethod(featureId);
        featureRepository.delete(feature);
        return mapper.featureToFeatureRequestDto(feature);
    }

    // Service internal methods
    public Feature getFeatureMethod(String featureId) {
        return featureRepository.findById(featureId).orElseThrow(() ->
                new IllegalArgumentException("Course not found"+featureId));
    }
}
