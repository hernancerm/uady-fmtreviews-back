package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentSatisfactionParameterMapper
        implements EntityDtoMapper<StudentSatisfactionParameter, StudentSatisfactionParameterDto> {

    @Override
    public StudentSatisfactionParameterDto entity2dto(StudentSatisfactionParameter studentSatisfactionParameter) {
        return StudentSatisfactionParameterDto.builder()
                .id(studentSatisfactionParameter.getId())

                .name(studentSatisfactionParameter.getName())
                .build();
    }

    @Override
    public StudentSatisfactionParameter dto2entity(StudentSatisfactionParameterDto studentSatisfactionParameterDto) {
        return StudentSatisfactionParameter.builder()
                .name(studentSatisfactionParameterDto.getName())
                .build();
    }
}
