package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceTypeDto;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class RecommendedResourceTypeMapper
        implements EntityDtoMapper<RecommendedResourceType, RecommendedResourceTypeDto> {

    @Override
    public RecommendedResourceTypeDto entity2dto(RecommendedResourceType recommendedResourceType) {
        return RecommendedResourceTypeDto.builder()
                .id(recommendedResourceType.getId())

                .name(recommendedResourceType.getName())
                .build();
    }

    @Override
    public RecommendedResourceType dto2entity(RecommendedResourceTypeDto recommendedResourceTypeDto) {
        return RecommendedResourceType.builder()
                .name(recommendedResourceTypeDto.getName())
                .build();
    }
}
