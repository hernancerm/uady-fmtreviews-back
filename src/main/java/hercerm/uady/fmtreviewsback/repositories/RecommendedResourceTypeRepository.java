package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecommendedResourceTypeRepository
        extends JpaRepository<RecommendedResourceType, Long> {

    Optional<RecommendedResourceType> findByName(String name);
}
