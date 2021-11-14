package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    @NotBlank
    @Size(min = 1, max = 500)
    private String description;

    @Builder.Default
    @Min(0)
    @Max(5)
    private Double studentSatisfactionGrade = 0.0;

    @OneToMany(cascade = CascadeType.ALL)
    List<@Valid StudentSatisfactionParameterPointed> studentSatisfactionGrades;

    @ManyToOne
    @Valid
    private Professor professor;

    @ManyToMany
    private List<@Valid ProfessorCharacteristic> professorCharacteristics;
}
