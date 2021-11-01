package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.ProfessorReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorReviewRepository extends JpaRepository<ProfessorReview, Long> {
    List<ProfessorReview> findAllByProfessorId(Long professorId);
    int countProfessorReviewsByProfessorId(Long professorId);
}
