package springboot.realstate_api.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.domain.features.Feature;
import springboot.realstate_api.domain.features.FeatureService;
import springboot.realstate_api.web.dto.FeatureDto;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/feature")
@AllArgsConstructor
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping
    public ResponseEntity<List<FeatureDto>> getFeatures() {
        List<FeatureDto> featureList = featureService.getFeatures().stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(featureList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeatureDto> create(@RequestBody FeatureDto featureRequestDto) {
        return new ResponseEntity<>(toDto(featureService.create(toModel(featureRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDto> getFeature(@PathVariable final String id) {
        return new ResponseEntity<>(toDto(featureService.getFeature(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeatureDto> delete(@PathVariable final String id) {
        return new ResponseEntity<>(toDto(featureService.delete(id)), HttpStatus.OK);
    }

    // Pending to FINISH
    public Feature toModel(FeatureDto featureRequestDto) {
        return Feature.builder()
                .id(featureRequestDto.getId())
                .name(featureRequestDto.getName())
                .createdAt(featureRequestDto.getCreatedAt())
                .updatedAt(featureRequestDto.getUpdatedAt())
                .deleted(featureRequestDto.isDeleted())
                .build();
    }

    public FeatureDto toDto(Feature feature) {
        return FeatureDto.builder()
                .id(feature.getId())
                .name(feature.getName())
                .createdAt(feature.getCreatedAt())
                .updatedAt(feature.getUpdatedAt())
                .deleted(feature.isDeleted())
                .build();
    }

}


