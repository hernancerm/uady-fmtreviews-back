package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSatisfactionParameterPointedDto {

    private Long id;

    private Double points;

    private StudentSatisfactionParameterDto studentSatisfactionParameter;

    public StudentSatisfactionParameterPointedDto(Double points,
                                                  StudentSatisfactionParameterDto studentSatisfactionParameter) {
        this.points = points;
        this.studentSatisfactionParameter = studentSatisfactionParameter;
    }
}
