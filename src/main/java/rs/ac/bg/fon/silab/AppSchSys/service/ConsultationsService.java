/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import rs.ac.bg.fon.silab.AppSchSys.dto.ConsultationDTO;

/**
 *
 * @author Dane
 */
public interface ConsultationsService {

    public List<ConsultationDTO> findAll();

    public List<ConsultationDTO> getConsultationsForTeacher(String teacherId);

    public ConsultationDTO generateConsultation(ConsultationDTO Consultation);

    public List<ConsultationDTO> getConsultationsFromTeachersCalendar(String teacherId, BigDecimal calendarId);

    public void deleteConsultations(BigInteger calendarId, BigInteger eventId);
}
