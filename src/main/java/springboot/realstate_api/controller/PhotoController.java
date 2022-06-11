package springboot.realstate_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;
import springboot.realstate_api.dto.responseDto.UploadFileResponse;
import springboot.realstate_api.service.FileStorageService;
import springboot.realstate_api.service.PhotoService;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    private static final Logger logger =  LoggerFactory.getLogger(PhotoController.class);

    private final PhotoService photoService;
    private final FileStorageService fileStorageService;

    @Autowired
    public PhotoController(PhotoService photoService, FileStorageService fileStorageService) {
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
            PhotoRequestDto photoRequestDto = new PhotoRequestDto();
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
    public ResponseEntity<PhotoRequestDto> deletePhoto(@PathVariable final String photoId) throws IOException {
        PhotoRequestDto photoRequestDto = photoService.deletePhotoFromProperty(photoId);
        fileStorageService.deleteFile(photoRequestDto.getName()); //new
        return new ResponseEntity<>(photoRequestDto, HttpStatus.OK);
    }

    @GetMapping("getPropertyPhotos/{propertyId}")
    public ResponseEntity<List<PhotoRequestDto>> getPropertyPhotos(@PathVariable final String propertyId) {
        List<PhotoRequestDto> photoRequestDtoList = photoService.getPropertyPhotos(propertyId);
        return new ResponseEntity<>(photoRequestDtoList, HttpStatus.OK);
    }


//    @PostMapping("addPhotoToProperty") // UPLOAD [URL]
//    public ResponseEntity<PhotoRequestDto> addPhotoToProperty(@RequestBody final PhotoRequestDto photoRequestDto) {
//        PhotoRequestDto photoRequestDto1 = photoService.addPhotoToProperty(photoRequestDto);
//        return new ResponseEntity<>(photoRequestDto1, HttpStatus.OK);
//    }


}
