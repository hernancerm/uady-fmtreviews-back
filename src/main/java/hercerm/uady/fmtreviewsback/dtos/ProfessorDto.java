package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorDto {

    private Long id;

    private String firstNames;
    private String lastNames;

    private String profileImage; // TODO: Remove attribute and attach image via service method

    @Builder.Default
    private Double studentSatisfactionScore = 0.0;
    @Builder.Default
    private Double sspExpertiseScore = 0.0;
    @Builder.Default
    private Double sspExplanationQualityScore = 0.0;
    @Builder.Default
    private Double sspWillingnessToHelpScore = 0.0;
}
