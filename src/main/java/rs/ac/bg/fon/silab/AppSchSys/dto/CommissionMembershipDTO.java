/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.util.Date;

/**
 *
 * @author Dane
 */
public class CommissionMembershipDTO extends EventDTO {

    private String eventLevel;
    private String function;
    private String candidate;
    private String topic;

    public CommissionMembershipDTO() {
    }

    public CommissionMembershipDTO(String eventLevel, String function, String candidate, String topic, EventPKDTO eventPK, Date startDateTime, Date endDateTime, String place, CalendarDTO calendarDTO, EventTypeDTO eventTypeId) {
        super(eventPK, startDateTime, endDateTime, place, calendarDTO, eventTypeId);
        this.eventLevel = eventLevel;
        this.function = function;
        this.candidate = candidate;
        this.topic = topic;
    }

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
