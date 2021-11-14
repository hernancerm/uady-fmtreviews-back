package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfessorMapper implements EntityDtoMapper<Professor, ProfessorDto> {

    private final StudentSatisfactionParameterPointedMapper studentSatisfactionParameterPointedMapper;

    public ProfessorMapper(StudentSatisfactionParameterPointedMapper studentSatisfactionParameterPointedMapper) {
        this.studentSatisfactionParameterPointedMapper = studentSatisfactionParameterPointedMapper;
    }

    @Override
    public ProfessorDto entity2dto(Professor professor) {
        return ProfessorDto.builder()
                .id(professor.getId())

                .firstNames(professor.getFirstNames())
                .lastNames(professor.getLastNames())
                .studentSatisfactionScore(professor.getStudentSatisfactionScore())

                .studentSatisfactionScores(professor.getStudentSatisfactionScores().stream()
                        .map(studentSatisfactionParameterPointedMapper::entity2dto).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Professor dto2entity(ProfessorDto professorDto) {
        return Professor.builder()
                .firstNames(professorDto.getFirstNames())
                .lastNames(professorDto.getLastNames())

                .build();
    }
}
