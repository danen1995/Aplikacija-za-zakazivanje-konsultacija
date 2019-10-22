package rs.ac.bg.fon.silab.AppSchSys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import rs.ac.bg.fon.silab.AppSchSys.entities.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(String roleName);
}
