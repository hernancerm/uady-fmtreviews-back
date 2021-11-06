package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;

import java.util.List;

public interface StudentSatisfactionParameterService {
    List<StudentSatisfactionParameterDto> getAll();

    StudentSatisfactionParameterDto create(
            StudentSatisfactionParameterDto studentSatisfactionParameterDto);

    StudentSatisfactionParameter mapDtoToSavedEntity(
            StudentSatisfactionParameterDto studentSatisfactionParameterDto);
}
