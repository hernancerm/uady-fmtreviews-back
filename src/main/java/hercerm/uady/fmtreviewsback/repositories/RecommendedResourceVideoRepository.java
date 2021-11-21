package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.RecommendedResourceVideo;
import hercerm.uady.fmtreviewsback.repositories.extensions.RecommendedResourceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface RecommendedResourceVideoRepository
        extends JpaRepository<RecommendedResourceVideo, Long>,
        RecommendedResourceRepository<RecommendedResourceVideo> {
}
