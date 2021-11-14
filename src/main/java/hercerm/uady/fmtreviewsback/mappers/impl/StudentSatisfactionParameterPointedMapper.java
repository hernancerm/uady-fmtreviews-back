package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterPointedDto;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameterPointed;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentSatisfactionParameterPointedMapper
        implements EntityDtoMapper<StudentSatisfactionParameterPointed, StudentSatisfactionParameterPointedDto> {

    private final StudentSatisfactionParameterMapper studentSatisfactionParameterMapper;

    public StudentSatisfactionParameterPointedMapper(StudentSatisfactionParameterMapper studentSatisfactionParameterMapper) {
        this.studentSatisfactionParameterMapper = studentSatisfactionParameterMapper;
    }

    @Override
    public StudentSatisfactionParameterPointedDto entity2dto(StudentSatisfactionParameterPointed studentSatisfactionParameterPointed) {
        return StudentSatisfactionParameterPointedDto.builder()
                .id(studentSatisfactionParameterPointed.getId())

                .points(studentSatisfactionParameterPointed.getPoints())

                .studentSatisfactionParameter(studentSatisfactionParameterMapper.entity2dto(
                        studentSatisfactionParameterPointed.getStudentSatisfactionParameter()))
                .build();
    }

    @Override
    public StudentSatisfactionParameterPointed dto2entity(StudentSatisfactionParameterPointedDto studentSatisfactionParameterPointedDto) {
        return StudentSatisfactionParameterPointed.builder()
                .points(studentSatisfactionParameterPointedDto.getPoints())
                .build();
    }
}
