package rs.ac.bg.fon.silab.AppKons.dao;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.entities.Student;

@Repository
public interface KorisnickiNalogDAO extends JpaRepository<KorisnickiNalog, BigDecimal> {

    @Query("SELECT k FROM KorisnickiNalog k WHERE k.korisnickoIme = ?1 and k.lozinka = ?2")
    public KorisnickiNalog login(String korisnickoIme, String korisnickaSifra);

    Optional <KorisnickiNalog> findByKorisnickoIme(String korisnickoIme);

    @Query("select case when count(c)> 0 then true else false end from KorisnickiNalog c where lower(c.korisnickoIme) like lower(?1)")
    public Boolean existsByKorisnickoIme(String korisnickoIme);

}
