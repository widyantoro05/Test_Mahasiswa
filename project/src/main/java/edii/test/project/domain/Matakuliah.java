package edii.test.project.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Matakuliah {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long idmatkul;
    private String namamatkul;
    @ManyToOne
    @JoinColumn(name = "id_mahasiswa")
    private Mahasiswa mahasiswa;

}
