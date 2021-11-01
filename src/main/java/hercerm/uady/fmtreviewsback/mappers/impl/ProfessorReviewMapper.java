package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorReview;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfessorReviewMapper implements EntityDtoMapper<ProfessorReview, ProfessorReviewDto> {

    private final ProfessorCharacteristicMapper professorCharacteristicMapper;

    public ProfessorReviewMapper(ProfessorCharacteristicMapper professorCharacteristicMapper) {
        this.professorCharacteristicMapper = professorCharacteristicMapper;
    }

    @Override
    public ProfessorReviewDto entity2dto(ProfessorReview professorReview) {
        return ProfessorReviewDto.builder()
                .id(professorReview.getId())
                .description(professorReview.getDescription())

                .studentSatisfaction(professorReview.getStudentSatisfaction())
                .sspExpertise(professorReview.getSspExpertise())
                .sspExplanationQuality(professorReview.getSspExplanationQuality())
                .sspWillingnessToHelp(professorReview.getSspWillingnessToHelp())

                .professorCharacteristics(professorReview.getProfessorCharacteristics().stream()
                        .map(professorCharacteristicMapper::entity2dto).collect(Collectors.toList()))
                .build();
    }

    @Override
    public ProfessorReview dto2entity(ProfessorReviewDto professorReviewDto) {
        return ProfessorReview.builder()
                .id(professorReviewDto.getId())
                .description(professorReviewDto.getDescription())

                .sspExpertise(professorReviewDto.getSspExpertise())
                .sspExplanationQuality(professorReviewDto.getSspExplanationQuality())
                .sspWillingnessToHelp(professorReviewDto.getSspWillingnessToHelp())

                .professorCharacteristics(professorReviewDto.getProfessorCharacteristics().stream()
                        .map(professorCharacteristicMapper::dto2entity).collect(Collectors.toList()))
                .build();
    }
}
