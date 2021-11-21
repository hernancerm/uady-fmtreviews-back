package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceAggregatorDto;
import hercerm.uady.fmtreviewsback.services.RecommendedResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RecommendedResourceController.BASE_URL)
public class RecommendedResourceController {

    public static final String BASE_URL =
            CourseController.BASE_URL + "/{courseId}/recommended-resources";

    private final RecommendedResourceService recommendedResourceService;

    public RecommendedResourceController(RecommendedResourceService recommendedResourceService) {
        this.recommendedResourceService = recommendedResourceService;
    }

    @GetMapping
    public List<RecommendedResourceAggregatorDto<?>> getRecommendedResourcesByCourseId(
            @PathVariable Long courseId) {
        return recommendedResourceService.getByCourseId(courseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object createRecommendedResource(HttpServletRequest request,
                                            @PathVariable Long courseId,
                                            @RequestParam String resourceTypeName) throws IOException {
        return recommendedResourceService.create(

                // Get request body from HttpServletRequest, see:
                // https://stackoverflow.com/a/31848289/12591546
                request.getReader().lines().collect(Collectors.joining(System.lineSeparator())),

                resourceTypeName,
                courseId);
    }
}
