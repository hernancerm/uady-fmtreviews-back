package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.entities.Professor;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProfessorService {
    List<ProfessorDto> getAll();
    ProfessorDto getById(Long professorId);
    byte[] getProfileImage(Long professorId) throws FileNotFoundException;

    /**
     * <p>
     *     Update the {@link Professor} entity as per the Dto supplied in the parameter.
     *     Provides support both for complete and partial updates.
     * </p>
     *
     * @param professorDto provided professor Dto, non-modified attributes might be null.
     * @return {@link ProfessorDto} with updated attributes as per the parameter.
     */
    ProfessorDto update(ProfessorDto professorDto);

    ProfessorDto create(ProfessorDto professorDto);
}
