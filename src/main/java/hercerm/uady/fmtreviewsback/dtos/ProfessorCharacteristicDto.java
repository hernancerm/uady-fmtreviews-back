package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorCharacteristicDto {

    private Long id;
    private String description;
}
