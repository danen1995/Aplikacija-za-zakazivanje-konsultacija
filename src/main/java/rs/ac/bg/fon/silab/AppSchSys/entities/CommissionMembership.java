/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dane
 */
@Entity
@DiscriminatorValue("1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommissionMembership.findByEventLevel", query = "SELECT d FROM CommissionMembership d WHERE d.eventLevel = :eventLevel")
    ,
    @NamedQuery(name = "CommissionMembership.findByFunction", query = "SELECT d FROM CommissionMembership d WHERE d.function = :function")
    ,
    @NamedQuery(name = "CommissionMembership.findByCandidate", query = "SELECT d FROM CommissionMembership d WHERE d.candidate = :candidate")
    ,
    @NamedQuery(name = "CommissionMembership.findByTopic", query = "SELECT d FROM CommissionMembership d WHERE d.topic = :topic")})
public class CommissionMembership extends Event implements Serializable {

    @Column(name = "EVENT_LEVEL")
    private String eventLevel;
    @Column(name = "FUNCTION")
    private String function;
    @Column(name = "CANDIDATE")
    private String candidate;
    @Column(name = "TOPIC")
    private String topic;

    public String getEventLevel() {
        return eventLevel;
    }

    public String getFunction() {
        return function;
    }

    public String getCandidate() {
        return candidate;
    }

    public String getTopic() {
        return topic;
    }

    public EventPK getEventPK() {
        return eventPK;
    }

    public void setEventLevel(String eventLevel) {
        this.eventLevel = eventLevel;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
