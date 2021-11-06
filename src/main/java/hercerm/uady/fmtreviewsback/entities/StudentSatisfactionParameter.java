package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSatisfactionParameter {

    public static final String EXPERTISE = "Experiencia demostrada en los temas";
    public static final String EXPLANATIONS = "Claridad en las explicaciones de clase";
    public static final String AD_HOC_HELP = "Voluntad de ayudar";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public StudentSatisfactionParameter(String name) {
        this.name = name;
    }
}
