package rs.ac.bg.fon.silab.AppSchSys.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AppSchSys.entities.Attachment;

@Repository
public interface AttachmentDAO extends JpaRepository<Attachment, BigDecimal> {

    @Query("SELECT p FROM Attachment p INNER JOIN ScheduledConsultation sk ON p.scheduledConsultation.studentConsultationPK = sk.studentConsultationPK WHERE sk.studentConsultationPK.calendarId = ?1 and sk.studentConsultationPK.eventId =?2 and sk.studentConsultationPK.indexNumber = ?3")
    public Attachment findByScheduledConsultation(BigInteger calendarId, BigInteger eventId, String indexNumber);

}
