package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.CourseDto;
import hercerm.uady.fmtreviewsback.services.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CourseController.BASE_URL)
public class CourseController {

    public static final String BASE_URL = "/api/courses";

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAll();
    }
}
