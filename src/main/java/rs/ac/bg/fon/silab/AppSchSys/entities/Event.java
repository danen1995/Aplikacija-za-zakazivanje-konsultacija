/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dane
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "EVENT_TYPE_ID", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT d FROM Event d")
    ,
    @NamedQuery(name = "Event.findByCalendarId", query = "SELECT d FROM Event d WHERE d.eventPK.calendarId = :calendarId")
    ,
    @NamedQuery(name = "Event.findByEventId", query = "SELECT d FROM Event d WHERE d.eventPK.eventId = :eventId")
    ,
    @NamedQuery(name = "Event.findByStartDateTime", query = "SELECT d FROM Event d WHERE d.startDateTime = :startDateTime")
    ,
    @NamedQuery(name = "Event.findByEndDateTime", query = "SELECT d FROM Event d WHERE d.endDateTime = :endDateTime")
    ,
    @NamedQuery(name = "Event.findByPlace", query = "SELECT d FROM Event d WHERE d.place = :place")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventPK eventPK;
    @Column(name = "START_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDateTime;
    @Column(name = "END_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDateTime;
    @Column(name = "PLACE")
    private String place;
    @JoinColumn(name = "CALENDAR_ID", referencedColumnName = "CALENDAR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Calendar calendar;
    @JoinColumn(name = "EVENT_TYPE_ID", referencedColumnName = "EVENT_TYPE_ID", insertable = false, updatable = false)
    @ManyToOne
    private EventType eventTypeId;

    public Event() {
    }

    public Event(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Event(BigInteger calendarId, BigInteger eventId) {
        this.eventPK = new EventPK(calendarId, eventId);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public EventPK getEventPK() {
        return eventPK;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public String getPlace() {
        return place;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public EventType getEventTypeId() {
        return eventTypeId;
    }

    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setEventTypeId(EventType eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventPK != null ? eventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventPK == null && other.eventPK != null) || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Event[ eventPK=" + eventPK + " ]";
    }

}
