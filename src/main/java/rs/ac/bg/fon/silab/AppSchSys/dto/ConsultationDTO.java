/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Dane
 */
public class ConsultationDTO extends EventDTO {

    private BigInteger capacity;
    private BigInteger numberOfScheduledCons;
//    private Collection<StudentKonsultacijeDTO> studentKonsultacijeCollection;

    public ConsultationDTO() {
    }

    public ConsultationDTO(BigInteger capacity, BigInteger numberOfScheduledCons) {
        this.capacity = capacity;
        this.numberOfScheduledCons = numberOfScheduledCons;
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

}
