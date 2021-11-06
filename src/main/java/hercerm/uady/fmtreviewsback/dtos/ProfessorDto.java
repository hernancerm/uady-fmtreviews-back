package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorDto {

    private Long id;

    private String firstNames;
    private String lastNames;

    @Builder.Default
    private Double studentSatisfactionScore = 0.0;
    @Builder.Default
    private Double sspExpertiseScore = 0.0;
    @Builder.Default
    private Double sspExplanationQualityScore = 0.0;
    @Builder.Default
    private Double sspWillingnessToHelpScore = 0.0;
}
