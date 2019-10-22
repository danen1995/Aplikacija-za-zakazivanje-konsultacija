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
public class AttachmentDTO {

    private BigDecimal attachmentId;
    private String name;
    private byte[] location;
    private ScheduledConsultationDTO scheduledConsultation;

    public AttachmentDTO() {
    }

    public AttachmentDTO(BigDecimal attachmentId, String name, byte[] location, ScheduledConsultationDTO scheduledConsultation) {
        this.attachmentId = attachmentId;
        this.name = name;
        this.location = location;
        this.scheduledConsultation = scheduledConsultation;
    }

    public BigDecimal getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(BigDecimal attachmentId) {
        this.attachmentId = attachmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public void setScheduledConsultation(ScheduledConsultationDTO scheduledConsultation) {
        this.scheduledConsultation = scheduledConsultation;
    }

    public String getName() {
        return name;
    }

    public byte[] getLocation() {
        return location;
    }

    public ScheduledConsultationDTO getScheduledConsultation() {
        return scheduledConsultation;
    }

}
