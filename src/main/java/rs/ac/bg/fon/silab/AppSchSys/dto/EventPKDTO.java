/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.math.BigInteger;

/**
 *
 * @author Dane
 */
public class EventPKDTO {

    private BigInteger calendarId;
    private BigInteger eventId;

    public EventPKDTO() {
    }

    public EventPKDTO(BigInteger calendarId, BigInteger eventId) {
        this.calendarId = calendarId;
        this.eventId = eventId;
    }

    public BigInteger geteventId() {
        return eventId;
    }

    public BigInteger getcalendarId() {
        return calendarId;
    }

    public void seteventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public void setcalendarId(BigInteger calendarId) {
        this.calendarId = calendarId;
    }

}
