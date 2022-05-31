package springboot.realstate_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.mapper;
import springboot.realstate_api.dto.requestDto.FeatureRequestDto;
import springboot.realstate_api.model.Feature;
import springboot.realstate_api.repository.FeatureRepository;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public List<FeatureRequestDto> getFeatures() {
        List<Feature> featureList = featureRepository.findAll();
        return mapper.featureToFeatureRequestDtos(featureList);
    }

    @Override
    public FeatureRequestDto addFeature(FeatureRequestDto featureRequestDto) {
        Feature feature = new Feature();
        feature.setName(featureRequestDto.getName());
        feature.setId(UUID.randomUUID().toString());
        featureRepository.save(feature);
        return mapper.featureToFeatureRequestDto(feature);
    }

    @Override
    public FeatureRequestDto getFeature(String featureId) {
        return mapper.featureToFeatureRequestDto(getFeatureMethod(featureId));
    }

    @Override
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
