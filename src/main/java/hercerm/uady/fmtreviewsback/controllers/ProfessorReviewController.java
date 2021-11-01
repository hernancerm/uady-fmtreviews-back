package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import hercerm.uady.fmtreviewsback.services.impl.ProfessorReviewServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProfessorReviewController.BASE_URL)
public class ProfessorReviewController {

    public static final String BASE_URL =  ProfessorController.BASE_URL + "/{professorId}/reviews";

    private final ProfessorReviewService professorReviewService;

    public ProfessorReviewController(ProfessorReviewService professorReviewService) {
        this.professorReviewService = professorReviewService;
    }

    @GetMapping
    public List<ProfessorReviewDto> getAllByProfessorId(@PathVariable Long professorId) {
        return professorReviewService.getAllByProfessorId(professorId);
    }
}
