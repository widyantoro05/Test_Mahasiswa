package edii.test.project.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Datanilai {
    @Id
    @GeneratedValue
    private Long id;
    private Integer nilai;
    private String keterangan;
    @ManyToOne
    @JoinColumn(name="id_mahasiswa")
    private Mahasiswa mahasiswa;
    @OneToOne
    @JoinColumn(name = "id_matakuliah")
    private Matakuliah matakuliah;
}
