package rs.ac.bg.fon.silab.AppKons.dao;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.silab.AppKons.entities.DogadjajPK;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.Prilog;

public interface PrilogDAO extends JpaRepository<Prilog, BigDecimal> {
    
    @Query("SELECT p FROM Prilog p INNER JOIN StudentKonsultacije sk ON p.studentKonsultacije.studentKonsultacijePK = sk.studentKonsultacijePK WHERE sk.studentKonsultacijePK.idKalendara = ?1 and sk.studentKonsultacijePK.idDogadjaja =?2 and sk.studentKonsultacijePK.brojIndeksaStudenta = ?3")
    public Prilog findByStudentKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksa);

  
}
