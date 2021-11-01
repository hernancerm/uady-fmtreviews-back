package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.ProfessorReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorReviewRepository extends JpaRepository<ProfessorReview, Long> {
}
