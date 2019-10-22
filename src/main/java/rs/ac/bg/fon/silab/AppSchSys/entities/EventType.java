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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "EVENT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventType.findAll", query = "SELECT t FROM EventType t")
    ,
    @NamedQuery(name = "EventType.findByEventTypeId", query = "SELECT t FROM EventType t WHERE t.eventTypeId = :eventTypeId")
    ,
    @NamedQuery(name = "EventType.findByName", query = "SELECT t FROM EventType t WHERE t.name = :name")})
public class EventType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EVENT_TYPE_ID")
    private BigDecimal eventTypeId;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "eventTypeId")
    @JsonBackReference(value = "eventCollection")

    private Collection<Event> eventCollection;

    public EventType() {
    }

    public EventType(BigDecimal eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getEventTypeId() {
        return eventTypeId;
    }

    public String getName() {
        return name;
    }

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventTypeId(BigDecimal eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventType)) {
            return false;
        }
        EventType other = (EventType) object;
        if ((this.eventTypeId == null && other.eventTypeId != null) || (this.eventTypeId != null && !this.eventTypeId.equals(other.eventTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.EventType[ eventTypeId=" + eventTypeId + " ]";
    }

}
