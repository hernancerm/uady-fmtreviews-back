package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSatisfactionParameterRepository
        extends JpaRepository<StudentSatisfactionParameter, Long> {
}
