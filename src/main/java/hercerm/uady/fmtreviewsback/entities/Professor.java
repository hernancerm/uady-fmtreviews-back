package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    private String firstNames;
    @NotEmpty
    private String lastNames;

    private String profileImage;

    @Builder.Default
    @Min(0)
    @Max(5)
    private Double studentSatisfactionScore = 0.0;

    @OneToMany(cascade = CascadeType.ALL)
    List<@Valid StudentSatisfactionParameterPointed> studentSatisfactionScores;
}
