package rs.ac.bg.fon.silab.AppKons.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastave;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastavePK;

@Repository
public interface PokrivenostDAO extends JpaRepository<PokrivenostNastave, PokrivenostNastavePK> {

    //@Query("SELECT s FROM Konsultacije s WHERE s.dogadjajPK.idDogadjaja = ?1")
    public List<PokrivenostNastave> findByJmbgNastavnika(String JMBGNastavnika);

}
