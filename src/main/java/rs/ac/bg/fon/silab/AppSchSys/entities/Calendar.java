/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "CALENDAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT k FROM Calendar k")
    ,
    @NamedQuery(name = "Calendar.findBycalendarId", query = "SELECT k FROM Calendar k WHERE k.calendarId = :calendarId")})
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CALENDAR_ID")
    private BigDecimal calendarId;
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "TEACHER_ID")
    @ManyToOne
    private Teacher teacher;
    @JoinColumn(name = "SCHOOL_YEAR_ID", referencedColumnName = "SCHOOL_YEAR_ID")
    @ManyToOne
    private SchoolYear schoolYearId;
    @JsonBackReference(value = "eventCollection")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendar")
    private Collection<Event> eventCollection;

    public Calendar() {
    }

    public Calendar(BigDecimal calendarId) {
        this.calendarId = calendarId;
    }

    public BigDecimal getCalendarId() {
        return calendarId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public SchoolYear getSchoolYearId() {
        return schoolYearId;
    }

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setCalendarId(BigDecimal calendarId) {
        this.calendarId = calendarId;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setSchoolYearId(SchoolYear schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarId != null ? calendarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.calendarId == null && other.calendarId != null) || (this.calendarId != null && !this.calendarId.equals(other.calendarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Calendar[ calendarId=" + calendarId + " ]";
    }

}
