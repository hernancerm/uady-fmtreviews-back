package hercerm.uady.fmtreviewsback.repositories.extensions;

import java.util.List;

public interface RecommendedResourceRepository<T> {
    List<T> findByCourseId(Long courseId);
}
