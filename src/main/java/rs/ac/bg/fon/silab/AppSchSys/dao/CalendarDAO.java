package rs.ac.bg.fon.silab.AppSchSys.dao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppSchSys.entities.Calendar;

@Repository
public interface CalendarDAO extends JpaRepository<Calendar, BigDecimal> {

    @Query("SELECT k FROM Calendar k INNER JOIN Teacher n on k.teacher.teacherId = n.teacherId WHERE n.teacherId=?1")
    public List<Calendar> getCalendarsForTeacher(String teacherId);

   
}
