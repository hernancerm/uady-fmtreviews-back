package hercerm.uady.fmtreviewsback.mappers.impl;

import hercerm.uady.fmtreviewsback.dtos.CourseDto;
import hercerm.uady.fmtreviewsback.entities.Course;
import hercerm.uady.fmtreviewsback.mappers.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements EntityDtoMapper<Course, CourseDto> {
    @Override
    public CourseDto entity2dto(Course course) {
        return CourseDto.builder()
                .id(course.getId())

                .name(course.getName())
                .build();
    }

    @Override
    public Course dto2entity(CourseDto courseDto) {
        return Course.builder()
                .name(courseDto.getName())
                .build();
    }
}
