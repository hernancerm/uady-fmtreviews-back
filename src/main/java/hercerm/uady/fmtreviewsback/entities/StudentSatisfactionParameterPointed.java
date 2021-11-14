package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSatisfactionParameterPointed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Max(5)
    private Double points;

    @ManyToOne
    @Valid
    private StudentSatisfactionParameter studentSatisfactionParameter;

    public StudentSatisfactionParameterPointed(Double points,
                                               StudentSatisfactionParameter studentSatisfactionParameter) {
        this.points = points;
        this.studentSatisfactionParameter = studentSatisfactionParameter;
    }
}
