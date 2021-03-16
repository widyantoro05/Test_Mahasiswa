package edii.test.project.repository;

import edii.test.project.domain.Datanilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataRepository extends JpaRepository<Datanilai,Long> {
    @Query(value="SELECT * FROM datanilai WHERE id= ?1", nativeQuery = true)
    Datanilai findByIdData(Long idData);
}
