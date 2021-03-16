package edii.test.project.repository;

import edii.test.project.domain.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository <Mahasiswa, Long> {
    @Query(value="SELECT * FROM mahasiswa WHERE id= ?1", nativeQuery = true)
    Mahasiswa findByIdMahasiswa(Long idMahasiswa);
    @Query(value= "select m.id,m.nama,mk.namamatkul,d.nilai \n" +
            "from mahasiswa m \n" +
            "inner join matakuliah mk on m.id=mk.id_mahasiswa\n" +
            "inner join datanilai d on mk.id=d.id_matakuliah",nativeQuery = true)
    List<Object> findDataMahasiswa();
    @Query(value = "select m.nama, round(avg(d.nilai),1) \n" +
            "from mahasiswa m \n" +
            "inner join matakuliah mk on m.id=mk.id_mahasiswa\n" +
            "inner join datanilai d on mk.id=d.id_matakuliah\n" +
            "group by m.nama\n" +
            "order by m.nama asc", nativeQuery = true)
    List<Object> findRataNilai();
}
