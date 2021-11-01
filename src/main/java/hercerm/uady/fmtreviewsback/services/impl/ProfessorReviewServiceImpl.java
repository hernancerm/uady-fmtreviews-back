package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.mappers.impl.ProfessorReviewMapper;
import hercerm.uady.fmtreviewsback.repositories.ProfessorReviewRepository;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorReviewServiceImpl implements ProfessorReviewService {

    private final ProfessorReviewRepository professorReviewRepository;

    private final ProfessorReviewMapper professorReviewMapper;

    public ProfessorReviewServiceImpl(ProfessorReviewRepository professorReviewRepository,
                                      ProfessorReviewMapper professorReviewMapper) {
        this.professorReviewRepository = professorReviewRepository;
        this.professorReviewMapper = professorReviewMapper;
    }

    @Override
    public List<ProfessorReviewDto> getAllByProfessorId(Long professorId) {
        return professorReviewRepository.findAllByProfessorId(professorId).stream()
                .map(professorReviewMapper::entity2dto).collect(Collectors.toList());
    }
}
