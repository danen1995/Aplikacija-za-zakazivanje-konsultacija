/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dane
 */
@Embeddable
public class ScheduledConsultationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CALENDAR_ID")
    private BigInteger calendarId;
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private BigInteger eventId;
    @Basic(optional = false)
    @Column(name = "INDEX_NUMBER")
    private String indexNumber;

    public ScheduledConsultationPK() {
    }

    public ScheduledConsultationPK(BigInteger calendarId, BigInteger eventId, String indexNumber) {
        this.calendarId = calendarId;
        this.eventId = eventId;
        this.indexNumber = indexNumber;
    }

    public void setCalendarId(BigInteger calendarId) {
        this.calendarId = calendarId;
    }

    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public BigInteger getCalendarId() {
        return calendarId;
    }

    public BigInteger getEventId() {
        return eventId;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarId != null ? calendarId.hashCode() : 0);
        hash += (eventId != null ? eventId.hashCode() : 0);
        hash += (indexNumber != null ? indexNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduledConsultationPK)) {
            return false;
        }
        ScheduledConsultationPK other = (ScheduledConsultationPK) object;
        if ((this.calendarId == null && other.calendarId != null) || (this.calendarId != null && !this.calendarId.equals(other.calendarId))) {
            return false;
        }
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        if ((this.indexNumber == null && other.indexNumber != null) || (this.indexNumber != null && !this.indexNumber.equals(other.indexNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.StudentConsultationPK[ calendarId=" + calendarId + ", eventId=" + eventId + ", indexNumber=" + indexNumber + " ]";
    }

}
