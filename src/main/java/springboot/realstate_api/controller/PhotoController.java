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
    public ResponseEntity<List<PhotoRequestDto>> getPropertyPhotos(@PathVariable final String propertyId) {
        List<PhotoRequestDto> photoRequestDtoList = photoService.getPropertyPhotos(propertyId);
        return new ResponseEntity<>(photoRequestDtoList, HttpStatus.OK);
    }

    @PostMapping("addPhotoToProperty")
    public ResponseEntity<PhotoRequestDto> addPhotoToProperty(@RequestBody final PhotoRequestDto photoRequestDto) {
        PhotoRequestDto photoRequestDto1 = photoService.addPhotoToProperty(photoRequestDto);
        return new ResponseEntity<>(photoRequestDto1, HttpStatus.OK);
    }

    @DeleteMapping("deletePhoto/{photoId}")
    public ResponseEntity<PhotoRequestDto> deletePhoto(@PathVariable final String photoId) {
        PhotoRequestDto photoRequestDto = photoService.deletePhotoFromProperty(photoId);
        return new ResponseEntity<>(photoRequestDto, HttpStatus.OK);
    }

}
