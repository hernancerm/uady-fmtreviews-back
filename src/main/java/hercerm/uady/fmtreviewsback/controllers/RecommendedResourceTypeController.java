package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceTypeDto;
import hercerm.uady.fmtreviewsback.services.RecommendedResourceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RecommendedResourceTypeController.BASE_URL)
public class RecommendedResourceTypeController {

    public static final String BASE_URL = CourseController.BASE_URL + "/recommended-resource-types";

    private final RecommendedResourceTypeService recommendedResourceTypeService;

    public RecommendedResourceTypeController(
            RecommendedResourceTypeService recommendedResourceTypeService) {
        this.recommendedResourceTypeService = recommendedResourceTypeService;
    }

    @GetMapping
    public List<RecommendedResourceTypeDto> getAllRecommendedResourceTypes() {
        return recommendedResourceTypeService.getAll();
    }
}
