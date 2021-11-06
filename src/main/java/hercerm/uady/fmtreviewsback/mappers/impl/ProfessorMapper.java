package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper implements EntityDtoMapper<Professor, ProfessorDto> {
    @Override
    public ProfessorDto entity2dto(Professor professor) {
        return ProfessorDto.builder()
                .id(professor.getId())

                .firstNames(professor.getFirstNames())
                .lastNames(professor.getLastNames())

                .studentSatisfactionScore(professor.getStudentSatisfactionScore())
                .sspExpertiseScore(professor.getSspExpertiseScore())
                .sspExplanationQualityScore(professor.getSspExplanationQualityScore())
                .sspWillingnessToHelpScore(professor.getSspWillingnessToHelpScore())
                .build();
    }

    @Override
    public Professor dto2entity(ProfessorDto professorDto) {
        return Professor.builder()
                .firstNames(professorDto.getFirstNames())
                .lastNames(professorDto.getLastNames())

                .sspExpertiseScore(professorDto.getSspExpertiseScore())
                .sspExplanationQualityScore(professorDto.getSspExplanationQualityScore())
                .sspWillingnessToHelpScore(professorDto.getSspWillingnessToHelpScore())
                .build();
    }
}
