package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceAggregatorDto;

import java.util.List;

public interface RecommendedResourceService {
    List<RecommendedResourceAggregatorDto<?>> getByCourseId(Long courseId);
    Object create(String recommendedResourceDtoJson, String recommendedResourceTypeName, Long courseId);
}
