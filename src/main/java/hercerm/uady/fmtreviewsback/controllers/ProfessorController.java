package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.services.ProfessorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(ProfessorController.BASE_URL)
public class ProfessorController {

    public static final String BASE_URL = "/api/professors";

    public final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<ProfessorDto> getAllProfessors() {
        return professorService.getAll();
    }


    @GetMapping("/{professorId}")
    public ProfessorDto getProfessorById(@PathVariable Long professorId) {
        return professorService.getById(professorId);
    }

    @GetMapping(value = "/{professorId}/profile-image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getProfessorProfileImageById(@PathVariable Long professorId) throws FileNotFoundException {
        return professorService.getProfileImage(professorId);
    }
}
