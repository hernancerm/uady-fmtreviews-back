package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.RecommendedResourceWebsite;
import hercerm.uady.fmtreviewsback.repositories.extensions.RecommendedResourceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendedResourceWebsiteRepository
        extends JpaRepository<RecommendedResourceWebsite, Long>,
        RecommendedResourceRepository<RecommendedResourceWebsite> {
}
