package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;

import java.util.List;

public interface ProfessorCharacteristicService {
    List<ProfessorCharacteristicDto> getAll();
    ProfessorCharacteristicDto create(ProfessorCharacteristicDto professorCharacteristicDto);
    List<ProfessorCharacteristic> mapProfessorCharacteristicDtosToSavedEntities(List<ProfessorCharacteristicDto> professorCharacteristicDtos);
}
