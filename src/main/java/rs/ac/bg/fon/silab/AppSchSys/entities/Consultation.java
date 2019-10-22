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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@DiscriminatorValue("2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findByCapacity", query = "SELECT d FROM Consultation d WHERE d.capacity = :capacity")
    ,
    @NamedQuery(name = "Consultation.findByNumberOfScheduledCons", query = "SELECT d FROM Consultation d WHERE d.numberOfScheduledCons = :numberOfScheduledCons")})
public class Consultation extends Event implements Serializable {

    @Column(name = "CAPACITY")
    private BigInteger capacity;
    @Column(name = "NUMBER_OF_SCHEDULED_CONS")
    private BigInteger numberOfScheduledCons;
    @JsonBackReference(value = "studentConsultationCollection")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Consultation")
    private Collection<ScheduledConsultation> studentConsultationCollection;

    public Consultation() {
    }

    public Consultation(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Consultation(BigInteger calendarId, BigInteger eventId) {
        this.eventPK = new EventPK(calendarId, eventId);
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public BigInteger getNumberOfScheduledCons() {
        return numberOfScheduledCons;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }

    public void setNumberOfScheduledCons(BigInteger numberOfScheduledCons) {
        this.numberOfScheduledCons = numberOfScheduledCons;
    }

    @XmlTransient
    public Collection<ScheduledConsultation> getStudentConsultationCollection() {
        return studentConsultationCollection;
    }

    public void setStudentConsultationCollection(Collection<ScheduledConsultation> studentConsultationCollection) {
        this.studentConsultationCollection = studentConsultationCollection;
    }

}
