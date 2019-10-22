/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.serviceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppSchSys.dto.ConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.EventPK;
import rs.ac.bg.fon.silab.AppSchSys.entities.Consultation;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.dao.ConsultationsDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.ConsultationsService;

/**
 *
 * @author Dane
 */
@Service
public class ConsultationsServiceImpl implements ConsultationsService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    ConsultationsDAO repository;

    public List<ConsultationDTO> findAll() {
        List<Consultation> kons = repository.findAll();
        List<ConsultationDTO> konsDTO = new ArrayList<>();
        for (Consultation k : kons) {
            konsDTO.add(mapper.ConsultationToConsultationDTO(k));
        }
        return konsDTO;
    }

    public List<ConsultationDTO> getConsultationsForTeacher(String teacherId) {
        List<Consultation> kons = repository.getConsultationsForTeacher(teacherId);
        List<ConsultationDTO> konsDTO = new ArrayList<>();
        for (Consultation k : kons) {
            konsDTO.add(mapper.ConsultationToConsultationDTO(k));
        }
        return konsDTO;
    }

    public ConsultationDTO generateConsultation(ConsultationDTO Consultation) {
        Consultation kons = mapper.ConsultationDTOToConsultation(Consultation);
        return mapper.ConsultationToConsultationDTO(repository.save(kons));
    }

    public List<ConsultationDTO> getConsultationsFromTeachersCalendar(String teacherId, BigDecimal calendarId) {
        List<Consultation> kons = repository.getConsultationsFromTeachersCalendar(teacherId, calendarId);
        List<ConsultationDTO> konsDTO = new ArrayList<>();
        for (Consultation k : kons) {
            konsDTO.add(mapper.ConsultationToConsultationDTO(k));
        }
        return konsDTO;
    }

    public void deleteConsultations(BigInteger calendarId, BigInteger eventId) {
        repository.deleteById(new EventPK(calendarId, eventId));
    }

}
