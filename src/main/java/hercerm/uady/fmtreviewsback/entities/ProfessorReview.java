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

    private Double studentSatisfaction;
    private Integer sspExpertise;
    private Integer sspExplanationQuality;
    private Integer sspWillingnessToHelp;

    @ManyToOne
    private Professor professor;

    @ManyToMany
    private List<ProfessorCharacteristic> professorCharacteristics;
}
