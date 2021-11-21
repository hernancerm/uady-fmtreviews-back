package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendedResourceTypeRepository
        extends JpaRepository<RecommendedResourceType, Long> {
}
