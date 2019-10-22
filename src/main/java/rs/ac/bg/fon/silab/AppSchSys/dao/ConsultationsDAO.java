package rs.ac.bg.fon.silab.AppSchSys.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppSchSys.entities.EventPK;
import rs.ac.bg.fon.silab.AppSchSys.entities.Consultation;

@Repository
public interface ConsultationsDAO extends JpaRepository<Consultation, EventPK> {

    @Query("SELECT s FROM Consultation s WHERE s.eventPK.eventId = ?1")
    public Consultation getConsultation(BigInteger eventId);

    @Query("SELECT s FROM Consultation s INNER JOIN Calendar k on s.eventPK.calendarId = k.calendarId INNER JOIN Teacher n on k.teacher.teacherId = n.teacherId WHERE n.teacherId = ?1 order by s.startDateTime ")
    public List<Consultation> getConsultationsForTeacher(String teacherId);

    @Query("SELECT s FROM Consultation s INNER JOIN Calendar k on s.eventPK.calendarId = k.calendarId INNER JOIN Teacher n on k.teacher.teacherId = n.teacherId WHERE n.teacherId = ?1 and k.calendarId=?2 order by s.startDateTime ")
    public List<Consultation> getConsultationsFromTeachersCalendar(String teacherId, BigDecimal calendarId);

}
