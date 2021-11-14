package hercerm.uady.fmtreviewsback.mappers;

public interface EntityDtoMapper<ENTITY, DTO> {
    DTO entity2dto(ENTITY entity);
    ENTITY dto2entity(DTO dto);
}
