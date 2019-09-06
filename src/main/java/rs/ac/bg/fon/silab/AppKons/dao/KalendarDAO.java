package rs.ac.bg.fon.silab.AppKons.dao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppKons.entities.Kalendar;

@Repository
public interface KalendarDAO extends JpaRepository<Kalendar, BigDecimal> {

    @Query("SELECT k FROM Kalendar k INNER JOIN Nastavnik n on k.nastavnik.jmbg = n.jmbg WHERE n.jmbg=?1")
    public List<Kalendar> vratiKalendareZaNastavnika(String JMBGNastavnika);

   
}
