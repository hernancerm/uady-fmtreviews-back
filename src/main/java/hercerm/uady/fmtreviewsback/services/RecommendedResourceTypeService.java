package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceTypeDto;

import java.util.List;

public interface RecommendedResourceTypeService {
    List<RecommendedResourceTypeDto> getAll();
    RecommendedResourceTypeDto create(RecommendedResourceTypeDto recommendedResourceTypeDto);
}
