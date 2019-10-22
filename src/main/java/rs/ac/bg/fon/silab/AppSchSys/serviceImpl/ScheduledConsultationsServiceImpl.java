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
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultation;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultationPK;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.dao.ScheduledConsultationsDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.ScheduledConsultationsService;

/**
 *
 * @author Dane
 */
@Service
public class ScheduledConsultationsServiceImpl implements ScheduledConsultationsService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    ScheduledConsultationsDAO repository;

    public List<ScheduledConsultation> findAll() {
        return repository.findAll();
    }

    public ScheduledConsultationDTO findById(BigInteger calendarId, BigInteger eventId, String indexNumber) {
        return mapper.scheduledConsultationToStudentConsultationDTO(repository.findById(new ScheduledConsultationPK(calendarId, eventId, indexNumber)).get());
    }

    public List<ScheduledConsultationDTO> findByIndexNumber(String indexNumber) {
        List<ScheduledConsultation> studentKons = repository.findByIndexNumber(indexNumber);
        List<ScheduledConsultationDTO> studentKonsDTO = new ArrayList<>();
        for (ScheduledConsultation studentKon : studentKons) {
            studentKonsDTO.add(mapper.scheduledConsultationToStudentConsultationDTO(studentKon));
        }
        return studentKonsDTO;
    }

    public List<ScheduledConsultationDTO> findByTeacherId(String teacherId) {
        List<ScheduledConsultation> studentKons = repository.findByTeacherId(teacherId);
        List<ScheduledConsultationDTO> studentKonsDTO = new ArrayList<>();
        for (ScheduledConsultation studentKon : studentKons) {
            studentKonsDTO.add(mapper.scheduledConsultationToStudentConsultationDTO(studentKon));
        }
        return studentKonsDTO;
    }

    public void deleteScheduledConsultations(BigInteger calendarId, BigInteger eventId, String indexNumber) {
        repository.deleteById(new ScheduledConsultationPK(calendarId, eventId, indexNumber));
    }

    public ScheduledConsultationDTO scheduleConsultation(ScheduledConsultationDTO Consultation) {
        return mapper.scheduledConsultationToStudentConsultationDTO(repository.save(mapper.scheduledConsultationDTOToStudentConsultation(Consultation)));
    }

    public ScheduledConsultationDTO updateConsultation(ScheduledConsultationDTO Consultation) {
        return mapper.scheduledConsultationToStudentConsultationDTO(repository.save(mapper.scheduledConsultationDTOToStudentConsultation(Consultation)));
    }

    public List<ScheduledConsultationDTO> getAllForEvent(BigDecimal calendarId, BigInteger eventId) {
        List<ScheduledConsultation> studentKons = repository.getAllForEvent(calendarId, eventId);
        List<ScheduledConsultationDTO> studentKonsDTO = new ArrayList<>();
        for (ScheduledConsultation studentKon : studentKons) {
            studentKonsDTO.add(mapper.scheduledConsultationToStudentConsultationDTO(studentKon));
        }
        return studentKonsDTO;
    }

}
