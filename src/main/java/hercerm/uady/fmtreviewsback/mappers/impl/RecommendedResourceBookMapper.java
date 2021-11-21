package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceBookDto;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceBook;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class RecommendedResourceBookMapper
        implements EntityDtoMapper<RecommendedResourceBook, RecommendedResourceBookDto> {

    private final CourseMapper courseMapper;
    private final RecommendedResourceTypeMapper recommendedResourceTypeMapper;

    public RecommendedResourceBookMapper(CourseMapper courseMapper,
                                          RecommendedResourceTypeMapper recommendedResourceTypeMapper) {
        this.courseMapper = courseMapper;
        this.recommendedResourceTypeMapper = recommendedResourceTypeMapper;
    }

    @Override
    public RecommendedResourceBookDto entity2dto(RecommendedResourceBook recommendedResourceBook) {
        return RecommendedResourceBookDto.builder()
                .id(recommendedResourceBook.getId())

                .title(recommendedResourceBook.getTitle())
                .description(recommendedResourceBook.getDescription())

                .course(courseMapper.entity2dto(recommendedResourceBook.getCourse()))

                .type(recommendedResourceTypeMapper.entity2dto(recommendedResourceBook.getType()))
                .build();
    }

    @Override
    public RecommendedResourceBook dto2entity(RecommendedResourceBookDto recommendedResourceBookDto) {
        return RecommendedResourceBook.builder()
                .title(recommendedResourceBookDto.getTitle())
                .description(recommendedResourceBookDto.getDescription())

                .build();
    }
}
