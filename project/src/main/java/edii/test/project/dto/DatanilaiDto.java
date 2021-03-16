package edii.test.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatanilaiDto {
    private Long id;
    private Integer nilai;
    private String keterangan;
}
