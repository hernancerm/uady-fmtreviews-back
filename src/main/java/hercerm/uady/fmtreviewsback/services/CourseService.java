package hercerm.uady.fmtreviewsback.services;

import hercerm.uady.fmtreviewsback.dtos.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto create(CourseDto courseDto);
}
