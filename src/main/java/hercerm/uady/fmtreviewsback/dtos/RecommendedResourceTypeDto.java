package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendedResourceTypeDto {

    private Long id;

    private String name;

    public RecommendedResourceTypeDto(String name) {
        this.name = name;
    }
}
