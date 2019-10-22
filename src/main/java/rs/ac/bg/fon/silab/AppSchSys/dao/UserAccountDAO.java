package rs.ac.bg.fon.silab.AppSchSys.dao;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.bg.fon.silab.AppSchSys.entities.UserAccount;

public interface UserAccountDAO extends JpaRepository<UserAccount, BigDecimal> {

    @Query("SELECT k FROM UserAccount k WHERE k.userName = ?1 and k.password = ?2")
    public UserAccount login(String userName, String password);

    Optional<UserAccount> findByUserName(String userName);

    Optional<UserAccount> findByUserAccountId(BigDecimal id);

    @Query("select case when count(c)> 0 then true else false end from UserAccount c where lower(c.userName) like lower(?1)")
    public Boolean existsByUserName(String userName);

    @Query("select case when count(c)> 0 then true else false end from UserAccount c where lower(c.student.indexNumber) like lower(?1)")
    public Boolean existsByIndexNumber(String indexNumber);

}
