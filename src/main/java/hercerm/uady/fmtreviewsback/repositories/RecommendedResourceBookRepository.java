package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.RecommendedResourceBook;
import hercerm.uady.fmtreviewsback.repositories.extensions.RecommendedResourceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendedResourceBookRepository
        extends JpaRepository<RecommendedResourceBook, Long>,
        RecommendedResourceRepository<RecommendedResourceBook> {
}
