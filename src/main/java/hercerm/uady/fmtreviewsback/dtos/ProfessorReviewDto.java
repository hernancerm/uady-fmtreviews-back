package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProfessorReviewDto {

    private Long id;

    private String description;

    @Builder.Default
    private Double studentSatisfactionGrade = 0.0;

    private List<StudentSatisfactionParameterPointedDto> studentSatisfactionGrades;

    private List<ProfessorCharacteristicDto> professorCharacteristics;
}
