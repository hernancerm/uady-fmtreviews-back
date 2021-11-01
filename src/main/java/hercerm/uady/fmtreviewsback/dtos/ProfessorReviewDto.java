package hercerm.uady.fmtreviewsback.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProfessorReviewDto {

    private Long id;

    private String description;

    @Builder.Default
    private Double studentSatisfaction = 0.0;
    @Builder.Default
    private Integer sspExpertise = 0;
    @Builder.Default
    private Integer sspExplanationQuality = 0;
    @Builder.Default
    private Integer sspWillingnessToHelp = 0;

    private List<ProfessorCharacteristicDto> professorCharacteristics;
}
