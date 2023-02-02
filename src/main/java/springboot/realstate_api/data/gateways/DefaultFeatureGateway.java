package springboot.realstate_api.data.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springboot.realstate_api.data.entities.FeatureEntity;
import springboot.realstate_api.data.repositories.FeatureRepository;
import springboot.realstate_api.domain.features.Feature;
import springboot.realstate_api.domain.features.FeatureGateway;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class DefaultFeatureGateway implements FeatureGateway {
    private final FeatureRepository featureRepository;

    @Override
    public List<Feature> getFeatures() {
        List<FeatureEntity> featureEntities = featureRepository.findAll();
        return featureEntities.stream().map(this::toModel).collect(toList());
    }

    @Override
    public Feature create(Feature feature) {
        return toModel(featureRepository.save(toEntity(feature)));
    }

    @Override
    public Feature getFeature(String featureId) {
        FeatureEntity featureEntity = featureRepository.findById(featureId).orElseThrow(() -> new RuntimeException("Error"));
        return toModel(featureEntity);
    }

    @Override
    public Feature delete(String featureId) {
        FeatureEntity featureEntity = featureRepository.findById(featureId).orElseThrow(() -> new RuntimeException("Error"));
        featureRepository.delete(featureEntity);
        return toModel(featureEntity);
    }

    // Builder methods...
    private Feature toModel(FeatureEntity featureEntity) {
        return Feature.builder()
                .id(featureEntity.getId())
                .name(featureEntity.getName())
                .createdAt(featureEntity.getCreatedAt())
                .updatedAt(featureEntity.getUpdatedAt())
                .deleted(featureEntity.isDeleted())
                .build();
    }

    private FeatureEntity toEntity(Feature feature) {
        return FeatureEntity.builder()
                .id(feature.getId())
                .name(feature.getName())
                .createdAt(feature.getCreatedAt())
                .updatedAt(feature.getUpdatedAt())
                .deleted(feature.isDeleted())
                .build();
    }


}
