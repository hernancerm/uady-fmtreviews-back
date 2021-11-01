package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.math.MathUtils;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import hercerm.uady.fmtreviewsback.services.ProfessorScoresService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ProfessorScoresServiceImpl implements ProfessorScoresService {

    private final ProfessorReviewService professorReviewService;

    public ProfessorScoresServiceImpl(@Lazy ProfessorReviewService professorReviewService) {
        this.professorReviewService = professorReviewService;
    }

    @Override
    public double computeReviewStudentSatisfaction(ProfessorReviewDto professorReviewDto) {
        return (professorReviewDto.getSspExpertise() +
                professorReviewDto.getSspExplanationQuality() +
                professorReviewDto.getSspWillingnessToHelp()) / 3.0;
    }

    @Override
    public void populateProfessorScoresOnNewReview(ProfessorDto professorDto, ProfessorReviewDto professorReviewDto) {
        int amountOfReviews = professorReviewService.countReviewsByProfessorId(professorDto.getId());

        professorDto.setStudentSatisfactionScore(MathUtils.computeMeanProvidedNewValue(
                professorDto.getStudentSatisfactionScore(), amountOfReviews, professorReviewDto.getStudentSatisfaction())
        );
        professorDto.setSspExpertiseScore(MathUtils.computeMeanProvidedNewValue(
                professorDto.getSspExpertiseScore(), amountOfReviews, professorReviewDto.getSspExpertise())
        );
        professorDto.setSspExplanationQualityScore(MathUtils.computeMeanProvidedNewValue(
                professorDto.getSspExplanationQualityScore(), amountOfReviews, professorReviewDto.getSspExplanationQuality())
        );
        professorDto.setSspWillingnessToHelpScore(MathUtils.computeMeanProvidedNewValue(
                professorDto.getSspWillingnessToHelpScore(), amountOfReviews, professorReviewDto.getSspWillingnessToHelp())
        );
    }
}
