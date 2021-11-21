package hercerm.uady.fmtreviewsback.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecommendedResourceVideoDto {

    private Long id;
    private String title;
    private String description;

    private CourseDto course;
    private RecommendedResourceTypeDto type;
}
