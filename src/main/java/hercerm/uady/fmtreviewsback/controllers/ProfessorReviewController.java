package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorReviewDto createProfessorReview(@PathVariable Long professorId,
                                                    @RequestBody ProfessorReviewDto professorReviewDto) {
        return professorReviewService.create(professorId, professorReviewDto);
    }
}
