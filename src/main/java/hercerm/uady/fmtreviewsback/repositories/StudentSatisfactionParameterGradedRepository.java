package hercerm.uady.fmtreviewsback.repositories;

import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameterPointed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSatisfactionParameterGradedRepository
        extends JpaRepository<StudentSatisfactionParameterPointed, Long> {
}
