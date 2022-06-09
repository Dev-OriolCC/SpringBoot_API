package springboot.realstate_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.FeatureRequestDto;
import springboot.realstate_api.service.FeatureService;

import java.util.List;

@RestController
@RequestMapping("/feature")
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    // Here go all methods to use our Feature Object
    @GetMapping("getFeatures")
    public ResponseEntity<List<FeatureRequestDto>> getFeatures() {
        List<FeatureRequestDto> featureList = featureService.getFeatures();
        return new ResponseEntity<>(featureList, HttpStatus.OK);
    }

    @PostMapping("postFeature")
    public ResponseEntity<FeatureRequestDto> addFeature(@RequestBody final FeatureRequestDto featureRequestDto) {
        FeatureRequestDto featureRequestDto1 = featureService.addFeature(featureRequestDto);
        return new ResponseEntity<>(featureRequestDto1, HttpStatus.OK);
    }

    @GetMapping("getFeature/{id}")
    public ResponseEntity<FeatureRequestDto> getFeature(@PathVariable final String id) {
        FeatureRequestDto featureRequestDto = featureService.getFeature(id);
        return new ResponseEntity<>(featureRequestDto, HttpStatus.OK);
    }

    @DeleteMapping("deleteFeature/{id}")
    public ResponseEntity<FeatureRequestDto> deleteFeature(@PathVariable final String id) {
        FeatureRequestDto featureRequestDto = featureService.deleteFeature(id);
        return new ResponseEntity<>(featureRequestDto, HttpStatus.OK);
    }

}


