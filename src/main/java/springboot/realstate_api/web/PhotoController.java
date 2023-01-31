package springboot.realstate_api.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springboot.realstate_api.domain.photos.Photo;
import springboot.realstate_api.domain.photos.PhotoService;
import springboot.realstate_api.web.dto.PhotoDto;
import springboot.realstate_api.web.dto.UploadFileResponse;
import springboot.realstate_api.domain.files.FileStorageService;
import springboot.realstate_api.domain.photos.PhotoGateway;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/photo")
@AllArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

//    @PostMapping("/uploadFile/{propertyId}")
//    public UploadFileResponse uploadFile(
//            @RequestParam("file") MultipartFile file,
//            @PathVariable final String propertyId)
//    {
//        String fileName = fileStorageService.storeFile(file);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/images/")
//                .path(fileName)
//                .toUriString();
//        // TEST
//        PhotoDto photoRequestDto = new PhotoDto();
//        photoRequestDto.setUrl(fileDownloadUri);
//        photoRequestDto.setName(fileName);
//        photoRequestDto.setPropertyId(propertyId);
//        photoRequestDto.setFileType(file.getContentType());
//        photoRequestDto.setSize(file.getSize());
//
//        photoService.addPhotoToProperty(photoRequestDto);
//        //
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<List<PhotoDto>> getPropertyPhotos(@PathVariable final String propertyId) {
        List<PhotoDto> photoDtos =  photoService.getPropertyPhotos(propertyId).stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(photoDtos, HttpStatus.OK);
    }

    private PhotoDto toDto(Photo photo) {
        return PhotoDto.builder()
                .id(photo.getId())
                .name(photo.getName())
                .fileType(photo.getFileType())
                .size(photo.getSize())
                .createdAt(photo.getCreatedAt())
                .updatedAt(photo.getUpdatedAt())
                .deleted(photo.isDeleted())
                .build();
    }


    /*
    private static final Logger logger =  LoggerFactory.getLogger(PhotoController.class);

    private final PhotoGateway photoService;
    private final FileStorageService fileStorageService;

    @Autowired
    public PhotoController(PhotoGateway photoService, FileStorageService fileStorageService) {
        this.photoService = photoService;
        this.fileStorageService = fileStorageService;
    }

    // ------------------------- FILE UPLOAD -------------------------
    @PostMapping("/uploadFile/{propertyId}")
    public UploadFileResponse uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable final String propertyId
            ) {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                //.path("/downloadFile/")
                .path("/images/")
                .path(fileName)
                .toUriString();
        // TEST
            PhotoDto photoRequestDto = new PhotoDto();
            photoRequestDto.setUrl(fileDownloadUri);
            photoRequestDto.setName(fileName);
            photoRequestDto.setPropertyId(propertyId);
            photoRequestDto.setFileType(file.getContentType());
            photoRequestDto.setSize(file.getSize());

            photoService.addPhotoToProperty(photoRequestDto);
        //
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    // ------------------------- URL UPLOAD -------------------------
    @DeleteMapping("deletePhoto/{photoId}") // DELETE[URL]
    public ResponseEntity<PhotoDto> deletePhoto(@PathVariable final String photoId) throws IOException {
        PhotoDto photoRequestDto = photoService.deletePhotoFromProperty(photoId);
        fileStorageService.deleteFile(photoRequestDto.getName()); //new
        return new ResponseEntity<>(photoRequestDto, HttpStatus.OK);
    }

    @GetMapping("getPropertyPhotos/{propertyId}")
    public ResponseEntity<List<PhotoDto>> getPropertyPhotos(@PathVariable final String propertyId) {
        List<PhotoDto> photoRequestDtoList = photoService.getPropertyPhotos(propertyId);
        return new ResponseEntity<>(photoRequestDtoList, HttpStatus.OK);
    }
     */


//    @PostMapping("addPhotoToProperty") // UPLOAD [URL]
//    public ResponseEntity<PhotoRequestDto> addPhotoToProperty(@RequestBody final PhotoRequestDto photoRequestDto) {
//        PhotoRequestDto photoRequestDto1 = photoService.addPhotoToProperty(photoRequestDto);
//        return new ResponseEntity<>(photoRequestDto1, HttpStatus.OK);
//    }


}
