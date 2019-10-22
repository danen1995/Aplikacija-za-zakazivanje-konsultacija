/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultation;

/**
 *
 * @author Dane
 */
public interface ScheduledConsultationsService {

    public List<ScheduledConsultation> findAll();

    public ScheduledConsultationDTO findById(BigInteger calendarId, BigInteger eventId, String indexNumber);

    public List<ScheduledConsultationDTO> findByIndexNumber(String indexNumber);

    public List<ScheduledConsultationDTO> findByTeacherId(String teacherId);

    public void deleteScheduledConsultations(BigInteger calendarId, BigInteger eventId, String indexNumber);

    public ScheduledConsultationDTO scheduleConsultation(ScheduledConsultationDTO Consultation);

    public ScheduledConsultationDTO updateConsultation(ScheduledConsultationDTO Consultation);

    public List<ScheduledConsultationDTO> getAllForEvent(BigDecimal calendarId, BigInteger eventId);

}
