package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.services.ProfessorCharacteristicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProfessorCharacteristicController.BASE_URL)
public class ProfessorCharacteristicController {

    public static final String BASE_URL = ProfessorController.BASE_URL +"/characteristics";

    private final ProfessorCharacteristicService professorCharacteristicService;

    public ProfessorCharacteristicController(ProfessorCharacteristicService professorCharacteristicService) {
        this.professorCharacteristicService = professorCharacteristicService;
    }

    @GetMapping
    public List<ProfessorCharacteristicDto> getAllProfessorCharacteristics() {
        return professorCharacteristicService.getAll();
    }
}
