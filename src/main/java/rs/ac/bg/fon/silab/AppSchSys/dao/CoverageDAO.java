package rs.ac.bg.fon.silab.AppSchSys.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppSchSys.entities.Coverage;
import rs.ac.bg.fon.silab.AppSchSys.entities.CoveragePK;

@Repository
public interface CoverageDAO extends JpaRepository<Coverage, CoveragePK> {

    //@Query("SELECT s FROM Consultation s WHERE s.eventPK.eventId = ?1")
    public List<Coverage> findByTeacherId(String teacherId);

}
