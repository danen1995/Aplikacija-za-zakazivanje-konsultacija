package rs.ac.bg.fon.silab.AppSchSys.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultation;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultationPK;

@Repository
public interface ScheduledConsultationsDAO extends JpaRepository<ScheduledConsultation, ScheduledConsultationPK> {

    public List<ScheduledConsultation> findByIndexNumber(String indexNumber);

    @Query("SELECT sk FROM ScheduledConsultation sk INNER JOIN Consultation k on sk.Consultation.eventPK.eventId = k.eventPK.eventId INNER JOIN Event d on k.eventPK.eventId = d.eventPK.eventId INNER JOIN Calendar k on d.eventPK.calendarId = k.calendarId INNER JOIN Teacher n on k.teacher = n.teacherId WHERE n.teacherId =?1")
    public List<ScheduledConsultation> findByTeacherId(String teacherId);

    @Query("SELECT sk FROM ScheduledConsultation sk INNER JOIN Consultation k on sk.Consultation.eventPK.eventId = k.eventPK.eventId INNER JOIN Event d on k.eventPK.eventId = d.eventPK.eventId INNER JOIN Calendar k on d.eventPK.calendarId = k.calendarId WHERE k.calendarId=?1 and d.eventPK.eventId=?2")
    public List<ScheduledConsultation> getAllForEvent(BigDecimal calendarId, BigInteger eventId);

}
