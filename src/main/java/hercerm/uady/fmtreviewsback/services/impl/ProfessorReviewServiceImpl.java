package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorReview;
import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.mappers.impl.ProfessorReviewMapper;
import hercerm.uady.fmtreviewsback.repositories.ProfessorRepository;
import hercerm.uady.fmtreviewsback.repositories.ProfessorReviewRepository;
import hercerm.uady.fmtreviewsback.services.ProfessorCharacteristicService;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import hercerm.uady.fmtreviewsback.services.ProfessorScoresService;
import hercerm.uady.fmtreviewsback.services.ProfessorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorReviewServiceImpl implements ProfessorReviewService {

    private final ProfessorReviewRepository professorReviewRepository;
    private final ProfessorRepository professorRepository;

    private final ProfessorService professorService;
    private final ProfessorScoresService professorScoresService;
    private final ProfessorCharacteristicService professorCharacteristicService;

    private final ProfessorReviewMapper professorReviewMapper;

    public ProfessorReviewServiceImpl(ProfessorReviewRepository professorReviewRepository,
                                      ProfessorRepository professorRepository,
                                      ProfessorService professorService,
                                      ProfessorScoresService professorScoresService,
                                      ProfessorCharacteristicService professorCharacteristicService,
                                      ProfessorReviewMapper professorReviewMapper) {
        this.professorReviewRepository = professorReviewRepository;
        this.professorRepository = professorRepository;
        this.professorService = professorService;
        this.professorScoresService = professorScoresService;
        this.professorCharacteristicService = professorCharacteristicService;
        this.professorReviewMapper = professorReviewMapper;
    }

    @Override
    public List<ProfessorReviewDto> getAllByProfessorId(Long professorId) {
        return professorReviewRepository.findAllByProfessorId(professorId).stream()
                .map(professorReviewMapper::entity2dto).collect(Collectors.toList());
    }

    @Override
    public int countReviewsByProfessorId(Long professorId) {
        return professorReviewRepository.countProfessorReviewsByProfessorId(professorId);
    }

    @Override
    @Transactional
    public ProfessorReviewDto create(Long professorId, ProfessorReviewDto professorReviewDto) {
        ProfessorReview professorReview = professorReviewMapper.dto2entity(professorReviewDto);

        double reviewStudentSatisfaction = professorScoresService.computeReviewStudentSatisfaction(professorReviewDto);

        professorReview.setStudentSatisfaction(reviewStudentSatisfaction);
        professorReviewDto.setStudentSatisfaction(reviewStudentSatisfaction);

        ProfessorDto fetchedProfessorDto = professorService.getById(professorId);
        professorScoresService.populateProfessorScoresOnNewReview(fetchedProfessorDto, professorReviewDto);
        professorService.update(fetchedProfessorDto);

        professorReview.setProfessor(professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found")));

        professorReview.setProfessorCharacteristics(professorCharacteristicService
                .mapProfessorCharacteristicDtosToSavedEntities(professorReviewDto.getProfessorCharacteristics()));

        ProfessorReview savedProfessorReview = professorReviewRepository.save(professorReview);
        return professorReviewMapper.entity2dto(savedProfessorReview);
    }
}
