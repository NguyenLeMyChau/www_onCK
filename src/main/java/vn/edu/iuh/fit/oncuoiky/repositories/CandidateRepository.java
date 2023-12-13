package vn.edu.iuh.fit.oncuoiky.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.oncuoiky.models.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query(value = "select distinct c.can_id, full_name, email, phone\n" +
            "    from candidate c JOIN experience e ON c.can_id = e.can_id\n" +
            "    where role = 1 AND company LIKE %:company%", nativeQuery = true)
    List<Candidate> findCandidateByRoleAndCompany(@Param("company") String company);

    @Query(value = "select distinct c.can_id, full_name, email, phone\n" +
            "from candidate c JOIN experience e ON c.can_id = e.can_id\n" +
            "where DATEDIFF(to_date, from_date) >= (365*5)", nativeQuery = true)
    List<Candidate> findCandidateByYear();

    @Query(value = "select distinct c.can_id, full_name, email, phone\n" +
            "from candidate c JOIN experience e ON c.can_id = e.can_id\n" +
            "where role = :role", nativeQuery = true)
    List<Candidate> findCandidateByRole(@Param("role") int role);
}