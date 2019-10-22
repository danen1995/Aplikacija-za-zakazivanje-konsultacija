/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.math.BigDecimal;

/**
 *
 * @author Dane
 */
public class EventTypeDTO {

    private BigDecimal eventTypeId;
    private String name;

//    private Collection<DogadjajDTO> eventCollection;
    public EventTypeDTO() {
    }

    public BigDecimal getEventTypeId() {
        return eventTypeId;
    }

    public String getName() {
        return name;
    }

    public void setEventTypeId(BigDecimal eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

}
