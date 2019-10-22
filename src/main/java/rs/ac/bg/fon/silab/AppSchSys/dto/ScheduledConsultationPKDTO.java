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
public class ScheduledConsultationPKDTO {

    private BigInteger calendarId;
    private BigInteger eventId;
    private String indexNumber;

    public String getBrojIndeksaStudenta() {
        return indexNumber;
    }

    public void setBrojIndeksaStudenta(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setcalendarId(BigInteger calendarId) {
        this.calendarId = calendarId;
    }

    public void seteventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public BigInteger getcalendarId() {
        return calendarId;
    }

    public BigInteger geteventId() {
        return eventId;
    }

    public ScheduledConsultationPKDTO(BigInteger calendarId, BigInteger eventId, String indexNumber) {
        this.calendarId = calendarId;
        this.eventId = eventId;
        this.indexNumber = indexNumber;
    }

    public ScheduledConsultationPKDTO() {
    }

}
