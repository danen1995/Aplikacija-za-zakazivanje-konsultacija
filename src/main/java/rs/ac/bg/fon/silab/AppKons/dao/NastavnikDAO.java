package rs.ac.bg.fon.silab.AppKons.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppKons.entities.Nastavnik;

@Repository
public interface NastavnikDAO extends JpaRepository<Nastavnik, String> {

    

}
