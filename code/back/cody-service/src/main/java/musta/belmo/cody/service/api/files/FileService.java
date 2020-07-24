package musta.belmo.cody.service.api.files;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
public interface FileService {
    String saveMultipart(MultipartFile multipartFile, String destinationDir) ;

    String saveMultipart(MultipartFile multipartFile, File destination) ;

    ResponseEntity<Resource> downloadFile(String fullUrl);
}
