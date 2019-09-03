package rs.ac.bg.fon.silab.AppKons.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import rs.ac.bg.fon.silab.AppKons.entities.Rola;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface RolaDAO extends JpaRepository<Rola, Long> {

    Optional<Rola> findByNazivRole(String nazivRole);
}
