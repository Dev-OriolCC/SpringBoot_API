package springboot.realstate_api.domain.features;

import java.util.List;

public interface FeatureGateway {
    //
    List<Feature> getFeatures();
    Feature create(Feature feature);
    Feature getFeature(String featureId);
    Feature delete(String featureId);
}
