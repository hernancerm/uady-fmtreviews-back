package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.CourseDto;
import hercerm.uady.fmtreviewsback.entities.Course;
import hercerm.uady.fmtreviewsback.mappers.impl.CourseMapper;
import hercerm.uady.fmtreviewsback.repositories.CourseRepository;
import hercerm.uady.fmtreviewsback.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::entity2dto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        Course savedCourse = courseRepository.save(courseMapper.dto2entity(courseDto));
        return courseMapper.entity2dto(savedCourse);
    }
}
