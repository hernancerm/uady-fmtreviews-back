package hercerm.uady.fmtreviewsback.dtos;

import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ProfessorReviewDto {

    private Long id;

    private String description;

    private Double studentSatisfaction;
    private Integer sspExpertise;
    private Integer sspExplanationQuality;
    private Integer sspWillingnessToHelp;

    private List<ProfessorCharacteristicDto> professorCharacteristics;
}
