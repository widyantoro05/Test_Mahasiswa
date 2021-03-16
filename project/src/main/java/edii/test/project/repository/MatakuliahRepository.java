package edii.test.project.repository;

import edii.test.project.domain.Matakuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatakuliahRepository extends JpaRepository<Matakuliah,Long> {
    @Query(value="SELECT * FROM matakuliah WHERE id= ?1", nativeQuery = true)
    Matakuliah findByIdMatakuliah(Long idMatkul);
}
