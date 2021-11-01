package hercerm.uady.fmtreviewsback.math;

import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.entities.ProfessorReview;

import java.util.List;

public final class ProfessorScores {

    public static void populateProfessorScores(Professor professor, List<ProfessorReview> reviews) {
        professor.setSspExpertiseScore(
                reviews.stream().mapToDouble(ProfessorReview::getSspExpertise).sum() / reviews.size());
        professor.setSspExplanationQualityScore(
                reviews.stream().mapToDouble(ProfessorReview::getSspExplanationQuality).sum() / reviews.size());
        professor.setSspWillingnessToHelpScore(
                reviews.stream().mapToDouble(ProfessorReview::getSspWillingnessToHelp).sum() / reviews.size());

        professor.setStudentSatisfactionScore(
                reviews.stream().mapToDouble(review ->
                        (review.getSspExpertise() +
                                review.getSspExplanationQuality() +
                                review.getSspWillingnessToHelp()) / 3.0
                ).sum() / reviews.size());
    }
}
