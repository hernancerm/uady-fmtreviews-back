package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.mappers.impl.ProfessorCharacteristicMapper;
import hercerm.uady.fmtreviewsback.repositories.ProfessorCharacteristicRepository;
import hercerm.uady.fmtreviewsback.services.ProfessorCharacteristicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorCharacteristicServiceImpl implements ProfessorCharacteristicService {

    private final ProfessorCharacteristicRepository professorCharacteristicRepository;

    private final ProfessorCharacteristicMapper professorCharacteristicMapper;

    public ProfessorCharacteristicServiceImpl(ProfessorCharacteristicRepository professorCharacteristicRepository,
                                              ProfessorCharacteristicMapper professorCharacteristicMapper) {
        this.professorCharacteristicRepository = professorCharacteristicRepository;
        this.professorCharacteristicMapper = professorCharacteristicMapper;
    }

    @Override
    public List<ProfessorCharacteristicDto> getAll() {
        return professorCharacteristicRepository.findAll().stream()
                .map(professorCharacteristicMapper::entity2dto).collect(Collectors.toList());
    }

    @Override
    public ProfessorCharacteristicDto create(ProfessorCharacteristicDto professorCharacteristicDto) {
        ProfessorCharacteristic professorCharacteristic =
                professorCharacteristicMapper.dto2entity(professorCharacteristicDto);

        // TODO: Validate professor characteristic before saving

        ProfessorCharacteristic savedProfessorCharacteristic =
                professorCharacteristicRepository.save(professorCharacteristic);
        return professorCharacteristicMapper.entity2dto(savedProfessorCharacteristic);
    }

    @Override
    public List<ProfessorCharacteristic> mapProfessorCharacteristicDtosToSavedEntities(
            List<ProfessorCharacteristicDto> professorCharacteristicDtos) {

        return professorCharacteristicDtos.stream()
                .map(characteristic -> professorCharacteristicRepository.findById(characteristic.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Professor characteristic not found")))
                .collect(Collectors.toList());
    }
}
