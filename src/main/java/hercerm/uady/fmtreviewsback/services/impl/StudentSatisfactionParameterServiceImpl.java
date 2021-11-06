package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.mappers.impl.StudentSatisfactionParameterMapper;
import hercerm.uady.fmtreviewsback.repositories.StudentSatisfactionParameterRepository;
import hercerm.uady.fmtreviewsback.services.StudentSatisfactionParameterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentSatisfactionParameterServiceImpl implements StudentSatisfactionParameterService {

    private final StudentSatisfactionParameterRepository studentSatisfactionParameterRepository;

    private final StudentSatisfactionParameterMapper studentSatisfactionParameterMapper;

    public StudentSatisfactionParameterServiceImpl(StudentSatisfactionParameterRepository studentSatisfactionParameterRepository,
                                                   StudentSatisfactionParameterMapper studentSatisfactionParameterMapper) {
        this.studentSatisfactionParameterRepository = studentSatisfactionParameterRepository;
        this.studentSatisfactionParameterMapper = studentSatisfactionParameterMapper;
    }

    @Override
    public List<StudentSatisfactionParameterDto> getAll() {
        return studentSatisfactionParameterRepository.findAll().stream()
                .map(studentSatisfactionParameterMapper::entity2dto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentSatisfactionParameterDto create(StudentSatisfactionParameterDto studentSatisfactionParameterDto) {
        // TODO: Validate studentSatisfactionParameterDto

        StudentSatisfactionParameter savedStudentSatisfactionParameter = studentSatisfactionParameterRepository
                .save(studentSatisfactionParameterMapper.dto2entity(studentSatisfactionParameterDto));

        return studentSatisfactionParameterMapper.entity2dto(savedStudentSatisfactionParameter);
    }

    @Override
    public StudentSatisfactionParameter mapDtoToSavedEntity(
            StudentSatisfactionParameterDto studentSatisfactionParameterDto) {

        return studentSatisfactionParameterRepository.findById(studentSatisfactionParameterDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Student satisfaction parameter not found"));
    }
}
