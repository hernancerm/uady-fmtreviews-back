package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfessorCharacteristicMapper
        implements EntityDtoMapper<ProfessorCharacteristic, ProfessorCharacteristicDto> {

    @Override
    public ProfessorCharacteristicDto entity2dto(ProfessorCharacteristic professorCharacteristic) {
        return ProfessorCharacteristicDto.builder()
                .id(professorCharacteristic.getId())
                .description(professorCharacteristic.getDescription())
                .build();
    }

    @Override
    public ProfessorCharacteristic dto2entity(ProfessorCharacteristicDto professorCharacteristicDto) {
        return ProfessorCharacteristic.builder()
                .id(professorCharacteristicDto.getId())
                .description(professorCharacteristicDto.getDescription())
                .build();
    }
}
