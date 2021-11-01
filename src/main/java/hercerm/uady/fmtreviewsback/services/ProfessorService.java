package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProfessorService {
    List<ProfessorDto> getAll();
    ProfessorDto getById(Long professorId);
    byte[] getProfileImage(Long professorId) throws FileNotFoundException;
}
