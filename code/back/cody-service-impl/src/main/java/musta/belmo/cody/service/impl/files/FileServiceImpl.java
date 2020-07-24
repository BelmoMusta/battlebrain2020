package musta.belmo.cody.service.impl.files;


import musta.belmo.cody.service.api.exceptions.ApplicationException;
import musta.belmo.cody.service.api.files.FileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
	
	@Override
	public String saveMultipart(MultipartFile multipartFile, File destination) {
		return saveMultipart(multipartFile, destination.getAbsolutePath());
	}
	
	@SuppressWarnings("all")
	@Override
	public String saveMultipart(MultipartFile multipartFile, String destinationDir) {
		
		if (multipartFile == null) {
			throw new ApplicationException(0, "file is empty");
		}
		final File dest = new File(destinationDir);
		if (!dest.exists()) {
			dest.mkdirs();
		}
		
		final String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		final File fileToSave = new File(dest, uuid.concat(".").concat(extension));
		try {
			fileToSave.createNewFile();
			final FileOutputStream output = new FileOutputStream(fileToSave);
			IOUtils.copy(multipartFile.getInputStream(), output);
			IOUtils.closeQuietly(output);
			return fileToSave.getAbsolutePath();
		} catch (IOException e) {
			return "";
		}
	}
	
	@Override
	public ResponseEntity<Resource> downloadFile(String fullUrl) {
		
		try {
			final FileSystemResource resource = new FileSystemResource(fullUrl);
			final String contentType = Files.probeContentType(new File(fullUrl).toPath());
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		} catch (IOException e) {
			return null;
		}
	}
}