package springboot.realstate_api.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.features.Feature;
import springboot.realstate_api.web.dto.requestDto.FeatureRequestDto;
import springboot.realstate_api.domain.features.FeatureGateway;

import java.util.List;

@RestController
@RequestMapping("/feature")
@AllArgsConstructor
public class FeatureController {

    private final FeatureGateway featureService;

    @GetMapping
    public ResponseEntity<List<FeatureRequestDto>> getFeatures() {
        List<FeatureRequestDto> featureList = featureService.getFeatures();
        return new ResponseEntity<>(featureList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeatureRequestDto> addFeature(@RequestBody final FeatureRequestDto featureRequestDto) {
        FeatureRequestDto featureRequestDto1 = featureService.addFeature(toModel(featureRequestDto));
        return new ResponseEntity<>(featureRequestDto1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureRequestDto> getFeature(@PathVariable final String id) {
        FeatureRequestDto featureRequestDto = featureService.getFeature(id);
        return new ResponseEntity<>(featureRequestDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeatureRequestDto> deleteFeature(@PathVariable final String id) {
        FeatureRequestDto featureRequestDto = featureService.deleteFeature(id);
        return new ResponseEntity<>(featureRequestDto, HttpStatus.OK);
    }

    public Feature toModel(FeatureRequestDto featureRequestDto) {
        return Feature.builder().name(featureRequestDto.getName()).build();
    }

}


