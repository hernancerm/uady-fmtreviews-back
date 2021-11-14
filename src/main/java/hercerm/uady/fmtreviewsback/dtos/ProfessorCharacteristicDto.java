package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorCharacteristicDto {

    private Long id;
    private String description;

    public ProfessorCharacteristicDto(String description) {
        this.description = description;
    }
}
