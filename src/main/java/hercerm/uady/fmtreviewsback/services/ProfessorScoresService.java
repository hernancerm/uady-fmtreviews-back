package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.entities.ProfessorReview;

/**
 * <p>
 *     Provides every computational need for scores about {@link Professor} or related classes, such as
 *     {@link ProfessorReview}. Thus, this class is entity-cross-cutting.
 * </p>
 */
public interface ProfessorScoresService {
    double computeReviewStudentSatisfaction(ProfessorReviewDto professorReviewDto);
    void populateProfessorScoresOnNewReview(ProfessorDto professorDto, ProfessorReviewDto professorReviewDto);
}
