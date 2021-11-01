package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.config.HttpHostConfig;
import hercerm.uady.fmtreviewsback.controllers.ProfessorController;
import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper implements EntityDtoMapper<Professor, ProfessorDto> {

    private final HttpHostConfig httpHostConfig;

    public ProfessorMapper(HttpHostConfig httpHostConfig) {
        this.httpHostConfig = httpHostConfig;
    }

    @Override
    public ProfessorDto entity2dto(Professor professor) {

        String profileImageEndpoint = String.format("%s:%d%s%s",
                httpHostConfig.getAddress(), httpHostConfig.getPort(),
                ProfessorController.BASE_URL, String.format("/%d/profile-image", professor.getId()));

        return ProfessorDto.builder()
                .id(professor.getId())
                .firstNames(professor.getFirstNames())
                .lastNames(professor.getLastNames())
                .profileImage(profileImageEndpoint)
                .studentSatisfactionScore(professor.getStudentSatisfactionScore())
                .sspExpertiseScore(professor.getSspExpertiseScore())
                .sspExplanationQualityScore(professor.getSspExplanationQualityScore())
                .sspWillingnessToHelpScore(professor.getSspWillingnessToHelpScore())
                .build();
    }

    @Override
    public Professor dto2entity(ProfessorDto professorDto) {
        return Professor.builder()
                .id(professorDto.getId())
                .firstNames(professorDto.getFirstNames())
                .lastNames(professorDto.getLastNames())
                .profileImage(professorDto.getProfileImage())
                .studentSatisfactionScore(professorDto.getStudentSatisfactionScore())
                .sspExpertiseScore(professorDto.getSspExpertiseScore())
                .sspExplanationQualityScore(professorDto.getSspExplanationQualityScore())
                .sspWillingnessToHelpScore(professorDto.getSspWillingnessToHelpScore())
                .build();
    }
}
