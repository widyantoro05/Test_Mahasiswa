package edii.test.project.dto;

import edii.test.project.domain.Mahasiswa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatakuliahDto {
    private String namamatkul;
    private Mahasiswa mahasiswa;
}
