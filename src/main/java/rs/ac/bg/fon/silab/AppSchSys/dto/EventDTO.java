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
public class EventDTO {

    private EventPKDTO eventPK;
    private Date startDateTime;
    private Date endDateTime;
    private String place;
    private CalendarDTO calendar;
    private EventTypeDTO eventTypeId;

    public EventDTO() {
    }

    public EventDTO(EventPKDTO eventPK, Date startDateTime, Date endDateTime, String place, CalendarDTO calendar, EventTypeDTO eventTypeId) {
        this.eventPK = eventPK;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.place = place;
        this.calendar = calendar;
        this.eventTypeId = eventTypeId;
    }

    public EventPKDTO getEventPK() {
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

    public CalendarDTO getCalendar() {
        return calendar;
    }

    public EventTypeDTO getEventTypeId() {
        return eventTypeId;
    }

    public void setEventPK(EventPKDTO eventPK) {
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

    public void setCalendar(CalendarDTO calendar) {
        this.calendar = calendar;
    }

    public void setEventTypeId(EventTypeDTO eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

}
