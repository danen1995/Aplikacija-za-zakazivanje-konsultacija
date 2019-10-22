/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.service;

import java.math.BigInteger;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AppSchSys.dto.AttachmentDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Attachment;

/**
 *
 * @author Dane
 */
public interface AttachmentService {

    public Attachment addAttachment(MultipartFile file, BigInteger calendarId, BigInteger eventId, String indexNumber);

    public List<AttachmentDTO> findAll();

    public Attachment findByScheduledConsultation(BigInteger calendarId, BigInteger eventId, String indexNumber);

}
