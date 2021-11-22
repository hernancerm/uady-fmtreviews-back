package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceVideoDto;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceVideo;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class RecommendedResourceVideoMapper
        implements EntityDtoMapper<RecommendedResourceVideo, RecommendedResourceVideoDto> {

    private final CourseMapper courseMapper;
    private final RecommendedResourceTypeMapper recommendedResourceTypeMapper;

    public RecommendedResourceVideoMapper(CourseMapper courseMapper,
                                          RecommendedResourceTypeMapper recommendedResourceTypeMapper) {
        this.courseMapper = courseMapper;
        this.recommendedResourceTypeMapper = recommendedResourceTypeMapper;
    }

    @Override
    public RecommendedResourceVideoDto entity2dto(RecommendedResourceVideo recommendedResourceVideo) {
        return RecommendedResourceVideoDto.builder()
                .id(recommendedResourceVideo.getId())

                .title(recommendedResourceVideo.getTitle())
                .description(recommendedResourceVideo.getDescription())

                .course(courseMapper.entity2dto(recommendedResourceVideo.getCourse()))

                .type(recommendedResourceTypeMapper.entity2dto(recommendedResourceVideo.getType()))
                .build();
    }

    @Override
    public RecommendedResourceVideo dto2entity(RecommendedResourceVideoDto recommendedResourceVideoDto) {
        return RecommendedResourceVideo.builder()
                .title(recommendedResourceVideoDto.getTitle())
                .description(recommendedResourceVideoDto.getDescription())

                .build();
    }
}
