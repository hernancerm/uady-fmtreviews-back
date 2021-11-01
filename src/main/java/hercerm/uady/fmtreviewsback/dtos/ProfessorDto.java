package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDto {

    private Long id;

    private String firstNames;
    private String lastNames;

    private String profileImage;

    private Double studentSatisfactionScore;
    private Double sspExpertiseScore;
    private Double sspExplanationQualityScore;
    private Double sspWillingnessToHelpScore;
}
