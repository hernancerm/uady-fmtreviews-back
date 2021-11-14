package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;

import java.util.List;

public interface ProfessorReviewService {
    List<ProfessorReviewDto> getAllByProfessorId(Long professorId);
    int countReviewsByProfessorId(Long professorId);
    ProfessorReviewDto create(Long professorId, ProfessorReviewDto professorReviewDto);
}
