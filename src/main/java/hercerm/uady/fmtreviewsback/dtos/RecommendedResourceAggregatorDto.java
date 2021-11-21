package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendedResourceAggregatorDto<RESOURCE_TYPE> {

    public RecommendedResourceTypeDto type;

    public List<RESOURCE_TYPE> resources;
}
