package rs.ac.bg.fon.silab.AppKons.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppKons.entities.DogadjajPK;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;

@Repository
public interface KonsultacijeDAO extends JpaRepository<Konsultacije, DogadjajPK> {

    @Query("SELECT s FROM Konsultacije s WHERE s.dogadjajPK.idDogadjaja = ?1")
    public Konsultacije vratiKonsultacije(BigInteger idDogadjaja);

    @Query("SELECT s FROM Konsultacije s INNER JOIN Kalendar k on s.dogadjajPK.idKalendara = k.idKalendara INNER JOIN Nastavnik n on k.nastavnik.jmbg = n.jmbg WHERE n.jmbg = ?1 order by s.datumIVremePocetka ")
    public List<Konsultacije> vratiKonsultacijeZaNastavnika(String JMBGNastavnika);

    @Query("SELECT s FROM Konsultacije s INNER JOIN Kalendar k on s.dogadjajPK.idKalendara = k.idKalendara INNER JOIN Nastavnik n on k.nastavnik.jmbg = n.jmbg WHERE n.jmbg = ?1 and k.idKalendara=?2 order by s.datumIVremePocetka ")
    public List<Konsultacije> vratiKonsultacijeZaNastavnikovKalendar(String jmbg, BigDecimal idKalendara);

}
