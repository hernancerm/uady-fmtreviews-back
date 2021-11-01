package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String description;

    @Builder.Default
    private Double studentSatisfaction = 0.0;
    @Builder.Default
    private Integer sspExpertise = 0;
    @Builder.Default
    private Integer sspExplanationQuality = 0;
    @Builder.Default
    private Integer sspWillingnessToHelp = 0;

    @ManyToOne
    private Professor professor;

    @ManyToMany
    private List<ProfessorCharacteristic> professorCharacteristics;
}
