package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSatisfactionParameterPointed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double points;

    @ManyToOne
    private StudentSatisfactionParameter studentSatisfactionParameter;

    public StudentSatisfactionParameterPointed(Double points,
                                               StudentSatisfactionParameter studentSatisfactionParameter) {
        this.points = points;
        this.studentSatisfactionParameter = studentSatisfactionParameter;
    }
}
