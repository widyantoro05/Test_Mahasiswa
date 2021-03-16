package edii.test.project.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String nama;
    private String alamat;


}
