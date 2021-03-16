package edii.test.project.assembler;

import edii.test.project.domain.Datanilai;
import edii.test.project.domain.Mahasiswa;
import edii.test.project.domain.Matakuliah;
import edii.test.project.dto.DatanilaiDto;
import edii.test.project.repository.MahasiswaRepository;
import edii.test.project.repository.MatakuliahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataAssembler implements Assembler<Datanilai, DatanilaiDto> {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    @Autowired
    private MatakuliahRepository matakuliahRepository;
    @Override
    public Datanilai fromDtoData(DatanilaiDto dto, Long idMatkul, Long idM) {
        if (dto==null){
            return null;
        }
        Mahasiswa mahasiswa = mahasiswaRepository.findByIdMahasiswa(idM);
        Matakuliah matakuliah = matakuliahRepository.findByIdMatakuliah(idMatkul);
        Datanilai ent = new Datanilai();
        ent.setMahasiswa(mahasiswa);
        ent.setMatakuliah(matakuliah);
        if(dto.getNilai()!=null){
            ent.setNilai(dto.getNilai());
        }
        if(dto.getKeterangan()!=null){
            ent.setKeterangan(dto.getKeterangan());
        }
        return ent;
    }

    @Override
    public Datanilai fromDto(DatanilaiDto datanilaiDto) {
        return null;
    }

    @Override
    public DatanilaiDto fromEntity(Datanilai ent) {
        if (ent==null) {
            return null;
        }
    return DatanilaiDto.builder()
            .nilai(ent.getNilai())
            .keterangan(ent.getKeterangan())
            .build();
    }
}
