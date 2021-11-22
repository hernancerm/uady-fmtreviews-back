package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;

    private String name;

    public CourseDto(String name) {
        this.name = name;
    }
}
