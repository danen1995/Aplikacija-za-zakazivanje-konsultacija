/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "SCHEDULED_CONSULTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledConsultation.findAll", query = "SELECT s FROM ScheduledConsultation s")
    ,
    @NamedQuery(name = "ScheduledConsultation.findByCalendarId", query = "SELECT s FROM ScheduledConsultation s WHERE s.studentConsultationPK.calendarId = :calendarId")
    ,
    @NamedQuery(name = "ScheduledConsultation.findByEventId", query = "SELECT s FROM ScheduledConsultation s WHERE s.studentConsultationPK.eventId = :eventId")
    ,
    @NamedQuery(name = "ScheduledConsultation.findByIndexNumber", query = "SELECT s FROM ScheduledConsultation s WHERE s.studentConsultationPK.indexNumber = ?")
    ,
    @NamedQuery(name = "ScheduledConsultation.findByStatus", query = "SELECT s FROM ScheduledConsultation s WHERE s.status = :status")
    ,
    @NamedQuery(name = "ScheduledConsultation.findByTitle", query = "SELECT s FROM ScheduledConsultation s WHERE s.title = :title")
    ,
    @NamedQuery(name = "ScheduledConsultation.findByDescription", query = "SELECT s FROM ScheduledConsultation s WHERE s.description = :description")})
public class ScheduledConsultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScheduledConsultationPK studentConsultationPK;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "scheduledConsultation")
    @JsonBackReference(value = "attachmentCollection")
    private Collection<Attachment> attachmentCollection;
    @JoinColumns({
        @JoinColumn(name = "CALENDAR_ID", referencedColumnName = "CALENDAR_ID", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Consultation Consultation;
    @JoinColumn(name = "INDEX_NUMBER", referencedColumnName = "INDEX_NUMBER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public ScheduledConsultation() {
    }

    public ScheduledConsultation(ScheduledConsultationPK studentConsultationPK) {
        this.studentConsultationPK = studentConsultationPK;
    }

    public ScheduledConsultation(BigInteger calendarId, BigInteger eventId, String indexNumber) {
        this.studentConsultationPK = new ScheduledConsultationPK(calendarId, eventId, indexNumber);
    }

    public void setStudentConsultationPK(ScheduledConsultationPK studentConsultationPK) {
        this.studentConsultationPK = studentConsultationPK;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttachmentCollection(Collection<Attachment> attachmentCollection) {
        this.attachmentCollection = attachmentCollection;
    }

    public void setConsultation(Consultation Consultation) {
        this.Consultation = Consultation;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ScheduledConsultationPK getStudentConsultationPK() {
        return studentConsultationPK;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Attachment> getAttachmentCollection() {
        return attachmentCollection;
    }

    public Consultation getConsultation() {
        return Consultation;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentConsultationPK != null ? studentConsultationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduledConsultation)) {
            return false;
        }
        ScheduledConsultation other = (ScheduledConsultation) object;
        if ((this.studentConsultationPK == null && other.studentConsultationPK != null) || (this.studentConsultationPK != null && !this.studentConsultationPK.equals(other.studentConsultationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.ScheduledConsultation[ studentConsultationPK=" + studentConsultationPK + " ]";
    }

}
