package edii.test.project.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {

    void upload(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException;

    void uploadEdit(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException;
}
