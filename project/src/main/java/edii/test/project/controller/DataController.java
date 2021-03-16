package edii.test.project.controller;

import edii.test.project.assembler.DataAssembler;
import edii.test.project.config.DefaultResponse;
import edii.test.project.domain.Datanilai;
import edii.test.project.dto.DatanilaiDto;
import edii.test.project.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataRepository repository;
    @Autowired
    private DataAssembler assembler;


    @PostMapping("/insert")
    public DefaultResponse insertDataNilai(@RequestParam Long idMatkul,
                                       @RequestParam Long idMahasiswa,
                                       @RequestBody DatanilaiDto dto) {
        Datanilai data = assembler.fromDtoData(dto, idMatkul, idMahasiswa);
        repository.save(data);
        return DefaultResponse.ok(assembler.fromEntity(data));
    }

    @DeleteMapping("/{idData}")
    public DefaultResponse delete(@PathVariable Long idData) {
        Datanilai datanilai = repository.findById(idData).get();
        repository.deleteById(idData);
        return DefaultResponse.ok(datanilai==null?"oke":null);
    }
    @PutMapping("/edit/{idData}")
    public  DefaultResponse editData (@PathVariable Long idData,
                                      @RequestBody DatanilaiDto dto){
        Datanilai data = repository.findByIdData(idData);
        Datanilai datanew = new Datanilai();
        datanew.setMatakuliah(data.getMatakuliah());
        datanew.setMahasiswa(data.getMahasiswa());
        datanew.setKeterangan(dto.getKeterangan());
        datanew.setNilai(dto.getNilai());
        datanew.setId(idData);
        repository.save(datanew);
        return DefaultResponse.ok(datanew);
    }


}
