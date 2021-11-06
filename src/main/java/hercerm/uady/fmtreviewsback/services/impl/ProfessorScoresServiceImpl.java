package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterPointedDto;
import hercerm.uady.fmtreviewsback.math.MathUtils;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import hercerm.uady.fmtreviewsback.services.ProfessorScoresService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProfessorScoresServiceImpl implements ProfessorScoresService {

    private final ProfessorReviewService professorReviewService;

    public ProfessorScoresServiceImpl(@Lazy ProfessorReviewService professorReviewService) {
        this.professorReviewService = professorReviewService;
    }

    @Override
    public double computeReviewStudentSatisfaction(ProfessorReviewDto professorReviewDto) {
        List<StudentSatisfactionParameterPointedDto> studentSatisfactionGrades =
                professorReviewDto.getStudentSatisfactionGrades();

        return studentSatisfactionGrades.stream()
                .mapToDouble(StudentSatisfactionParameterPointedDto::getPoints)
                .sum() / studentSatisfactionGrades.size();
    }

    @Override
    public void populateProfessorScoresOnNewReview(ProfessorDto professorDto, ProfessorReviewDto professorReviewDto) {
        int amountOfReviews = professorReviewService.countReviewsByProfessorId(professorDto.getId());

        professorDto.setStudentSatisfactionScore(MathUtils.computeMeanProvidedNewValue(
                professorDto.getStudentSatisfactionScore(), amountOfReviews, professorReviewDto.getStudentSatisfactionGrade())
        );

        // Key: StudentSatisfactionParameter ID / Value: StudentSatisfactionParameterPointed POINTS.
        Map<Long, Double> reviewParameterGrades = professorReviewDto.getStudentSatisfactionGrades().stream()
                        .collect(Collectors.toMap(
                                parameterGrade -> parameterGrade.getStudentSatisfactionParameter().getId(),
                                StudentSatisfactionParameterPointedDto::getPoints
                        ));

        professorDto.getStudentSatisfactionScores().forEach(
                parameterScore -> parameterScore.setPoints(MathUtils.computeMeanProvidedNewValue(
                        parameterScore.getPoints(), amountOfReviews,
                        reviewParameterGrades.get(parameterScore.getStudentSatisfactionParameter().getId())
                ))
        );
    }
}
