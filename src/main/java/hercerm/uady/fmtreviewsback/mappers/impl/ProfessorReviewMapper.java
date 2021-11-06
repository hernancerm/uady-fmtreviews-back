package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorReview;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfessorReviewMapper implements EntityDtoMapper<ProfessorReview, ProfessorReviewDto> {

    private final ProfessorCharacteristicMapper professorCharacteristicMapper;
    private final StudentSatisfactionParameterPointedMapper studentSatisfactionParameterPointedMapper;

    public ProfessorReviewMapper(ProfessorCharacteristicMapper professorCharacteristicMapper,
                                 StudentSatisfactionParameterPointedMapper studentSatisfactionParameterPointedMapper) {
        this.professorCharacteristicMapper = professorCharacteristicMapper;
        this.studentSatisfactionParameterPointedMapper = studentSatisfactionParameterPointedMapper;
    }

    @Override
    public ProfessorReviewDto entity2dto(ProfessorReview professorReview) {
        return ProfessorReviewDto.builder()
                .id(professorReview.getId())
                .description(professorReview.getDescription())

                .studentSatisfactionGrade(professorReview.getStudentSatisfactionGrade())

                .studentSatisfactionGrades(professorReview.getStudentSatisfactionGrades().stream()
                        .map(studentSatisfactionParameterPointedMapper::entity2dto).collect(Collectors.toList()))

                .professorCharacteristics(professorReview.getProfessorCharacteristics().stream()
                        .map(professorCharacteristicMapper::entity2dto).collect(Collectors.toList()))
                .build();
    }

    @Override
    public ProfessorReview dto2entity(ProfessorReviewDto professorReviewDto) {
        return ProfessorReview.builder()
                .description(professorReviewDto.getDescription())
                .build();
    }
}
