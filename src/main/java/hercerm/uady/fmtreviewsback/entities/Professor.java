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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstNames;
    private String lastNames;

    private String profileImage;

    @Builder.Default
    private Double studentSatisfactionScore = 0.0;

    @OneToMany(cascade = CascadeType.ALL)
    List<StudentSatisfactionParameterPointed> studentSatisfactionScores;
}
