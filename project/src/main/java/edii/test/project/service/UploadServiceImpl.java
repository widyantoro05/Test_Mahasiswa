package edii.test.project.service;

import edii.test.project.domain.Mahasiswa;
import edii.test.project.repository.MahasiswaRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public void upload(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException {
        Path tempDir = Files.createTempDirectory("");

        File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();

        file.transferTo(tempFile);

        Workbook workbook = WorkbookFactory.create(tempFile);
        for (Sheet sheet :workbook){
            for(Row row:sheet){
                String nama = row.getCell(0).getStringCellValue();
                String alamat = row.getCell(1).getStringCellValue();

                Mahasiswa ent = new Mahasiswa();
                ent.setNama(nama);
                ent.setAlamat(alamat);
                mahasiswaRepository.save(ent);
            }
        }
    }

    @Override
    public void uploadEdit(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException {
        Path tempDir = Files.createTempDirectory("");

        File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();

        file.transferTo(tempFile);

        Workbook workbook = WorkbookFactory.create(tempFile);
        for (Sheet sheet :workbook){
            for(Row row:sheet){
                double id =  row.getCell(0).getNumericCellValue();
                String nama = row.getCell(1).getStringCellValue();
                String alamat = row.getCell(2).getStringCellValue();

                Mahasiswa ent = new Mahasiswa();
                ent.setId((long) id);
                ent.setNama(nama);
                ent.setAlamat(alamat);
                mahasiswaRepository.save(ent);
            }
        }
    }
}
