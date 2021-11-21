package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceWebsiteDto;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceWebsite;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class RecommendedResourceWebsiteMapper
        implements EntityDtoMapper<RecommendedResourceWebsite, RecommendedResourceWebsiteDto> {

    private final CourseMapper courseMapper;
    private final RecommendedResourceTypeMapper recommendedResourceTypeMapper;

    public RecommendedResourceWebsiteMapper(CourseMapper courseMapper,
                                         RecommendedResourceTypeMapper recommendedResourceTypeMapper) {
        this.courseMapper = courseMapper;
        this.recommendedResourceTypeMapper = recommendedResourceTypeMapper;
    }

    @Override
    public RecommendedResourceWebsiteDto entity2dto(RecommendedResourceWebsite recommendedResourceWebsite) {
        return RecommendedResourceWebsiteDto.builder()
                .id(recommendedResourceWebsite.getId())

                .title(recommendedResourceWebsite.getTitle())
                .description(recommendedResourceWebsite.getDescription())

                .course(courseMapper.entity2dto(recommendedResourceWebsite.getCourse()))

                .type(recommendedResourceTypeMapper.entity2dto(recommendedResourceWebsite.getType()))
                .build();
    }

    @Override
    public RecommendedResourceWebsite dto2entity(RecommendedResourceWebsiteDto recommendedResourceWebsiteDto) {
        return RecommendedResourceWebsite.builder()
                .title(recommendedResourceWebsiteDto.getTitle())
                .description(recommendedResourceWebsiteDto.getDescription())

                .build();
    }
}
