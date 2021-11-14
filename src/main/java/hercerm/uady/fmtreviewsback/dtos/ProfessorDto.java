package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProfessorDto {

    private Long id;

    private String firstNames;
    private String lastNames;

    @Builder.Default
    private Double studentSatisfactionScore = 0.0;

    private List<StudentSatisfactionParameterPointedDto> studentSatisfactionScores;
}
