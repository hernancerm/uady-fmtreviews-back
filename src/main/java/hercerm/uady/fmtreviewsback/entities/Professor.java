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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstNames;
    private String lastNames;

    private String profileImage;

    @Builder.Default
    private Double studentSatisfactionScore = 0.0;
    @Builder.Default
    private Double sspExpertiseScore = 0.0;
    @Builder.Default
    private Double sspExplanationQualityScore = 0.0;
    @Builder.Default
    private Double sspWillingnessToHelpScore = 0.0;
}
