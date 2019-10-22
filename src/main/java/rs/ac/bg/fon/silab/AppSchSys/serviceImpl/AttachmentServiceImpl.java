/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.serviceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AppSchSys.dto.AttachmentDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Attachment;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultation;
import rs.ac.bg.fon.silab.AppSchSys.dao.AttachmentDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.AttachmentService;

/**
 *
 * @author Dane
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    AttachmentDAO repository;

    public Attachment addAttachment(MultipartFile file, BigInteger calendarId, BigInteger eventId, String indexNumber) {
        try {
            Attachment p = new Attachment(file.getOriginalFilename(), file.getBytes(), new ScheduledConsultation(calendarId, eventId, indexNumber));
            return repository.save(p);

        } catch (Exception ex) {
            return null;
        }

    }

    public List<AttachmentDTO> findAll() {
        List<Attachment> prilozi = repository.findAll();
        List<AttachmentDTO> priloziDTO = new ArrayList<>();
        for (Attachment p : prilozi) {
            priloziDTO.add(mapper.attachmentTOAttachmentDTO(p));
        }
        return priloziDTO;
    }

    public Attachment findByScheduledConsultation(BigInteger calendarId, BigInteger eventId, String indexNumber) {
        return repository.findByScheduledConsultation(calendarId, eventId, indexNumber);
    }

}
