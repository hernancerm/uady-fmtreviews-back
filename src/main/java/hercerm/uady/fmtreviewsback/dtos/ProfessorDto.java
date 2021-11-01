package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
