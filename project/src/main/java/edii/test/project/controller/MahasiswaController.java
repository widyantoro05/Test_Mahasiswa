package edii.test.project.controller;

import edii.test.project.config.DefaultResponse;
import edii.test.project.repository.MahasiswaRepository;
import edii.test.project.service.UploadService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    @Autowired
    private final UploadService uploadService;
    @Autowired
    MahasiswaRepository repository;

    public MahasiswaController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/rinciandata")
    public DefaultResponse getRincianData() {
        List<Object> rinciandata = repository.findDataMahasiswa();
        return DefaultResponse.ok(rinciandata);
    }
    @GetMapping("/dataratarata")
    public DefaultResponse getRataRata() {
        List<Object> ratarata = repository.findRataNilai();
        return DefaultResponse.ok(ratarata);
    }
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException, InvalidFormatException {
        uploadService.upload(file);
    }
    @PostMapping("/uploadEdit")
    public void uploadEdit(@RequestParam("file") MultipartFile file) throws IOException, InvalidFormatException {
        uploadService.uploadEdit(file);
    }
}
