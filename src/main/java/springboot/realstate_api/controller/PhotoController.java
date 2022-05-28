package springboot.realstate_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;
import springboot.realstate_api.service.PhotoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("getPropertyPhotos/{propertyId}")
    public ResponseEntity<List<PhotoRequestDto>> getPropertyPhotos(@PathVariable final UUID propertyId) {
        List<PhotoRequestDto> photoRequestDtoList = photoService.getPropertyPhotos(propertyId);
        return new ResponseEntity<>(photoRequestDtoList, HttpStatus.OK);
    }

    @PostMapping("addPhoto")
    public ResponseEntity<PhotoRequestDto> addPhoto(@RequestBody final PhotoRequestDto photoRequestDto) {
        PhotoRequestDto photoRequestDto1 = photoService.addPhoto(photoRequestDto);
        return new ResponseEntity<>(photoRequestDto1, HttpStatus.OK);
    }

    @DeleteMapping("deletePhoto/{propertyId}")
    public ResponseEntity<PhotoRequestDto> deletePhoto(@PathVariable final UUID propertyId) {
        PhotoRequestDto photoRequestDto = photoService.deletePhoto(propertyId);
        return new ResponseEntity<>(photoRequestDto, HttpStatus.OK);
    }

}
