package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceTypeDto;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import hercerm.uady.fmtreviewsback.mappers.impl.RecommendedResourceTypeMapper;
import hercerm.uady.fmtreviewsback.repositories.RecommendedResourceTypeRepository;
import hercerm.uady.fmtreviewsback.services.RecommendedResourceTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendedResourceTypeServiceImpl implements RecommendedResourceTypeService {

    private final RecommendedResourceTypeRepository recommendedResourceTypeRepository;

    private final RecommendedResourceTypeMapper recommendedResourceTypeMapper;

    public RecommendedResourceTypeServiceImpl(
            RecommendedResourceTypeRepository recommendedResourceTypeRepository,
            RecommendedResourceTypeMapper recommendedResourceTypeMapper) {
        this.recommendedResourceTypeRepository = recommendedResourceTypeRepository;
        this.recommendedResourceTypeMapper = recommendedResourceTypeMapper;
    }

    @Override
    public List<RecommendedResourceTypeDto> getAll() {
        return recommendedResourceTypeRepository.findAll().stream()
                .map(recommendedResourceTypeMapper::entity2dto)
                .collect(Collectors.toList());
    }

    @Override
    public RecommendedResourceTypeDto create(RecommendedResourceTypeDto recommendedResourceTypeDto) {
        // TODO: Validate recommendedResourceTypeDto.

        RecommendedResourceType createdResourceType = recommendedResourceTypeRepository
                .save(recommendedResourceTypeMapper.dto2entity(recommendedResourceTypeDto));

        return recommendedResourceTypeMapper.entity2dto(createdResourceType);
    }
}
