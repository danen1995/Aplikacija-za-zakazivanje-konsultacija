package rs.ac.bg.fon.silab.AppKons.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppKons.entities.Prilog;

@Repository
public interface PrilogDAO extends JpaRepository<Prilog, BigDecimal> {
    
    @Query("SELECT p FROM Prilog p INNER JOIN StudentKonsultacije sk ON p.studentKonsultacije.studentKonsultacijePK = sk.studentKonsultacijePK WHERE sk.studentKonsultacijePK.idKalendara = ?1 and sk.studentKonsultacijePK.idDogadjaja =?2 and sk.studentKonsultacijePK.brojIndeksaStudenta = ?3")
    public Prilog findByStudentKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksa);

  
}
