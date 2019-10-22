package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AppSchSys.dto.AttachmentDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Attachment;
import rs.ac.bg.fon.silab.AppSchSys.service.AttachmentService;

@RestController
@RequestMapping("/attachment")
@CrossOrigin
public class AttachmentRestController {

    @Autowired
    AttachmentService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CrossOrigin
    public @ResponseBody
    Object addAttachment(@RequestParam MultipartFile file, @RequestParam BigInteger calendarId, @RequestParam BigInteger eventId, @RequestParam String indexNumber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.addAttachment(file, calendarId, eventId, indexNumber));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error.");
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin
    public ResponseEntity<Object> uploadFile(@RequestParam MultipartFile file2, @RequestParam String fileName) throws IOException {
        File convertFile = new File("D:\\Desktop\\Diplomski rad\\Front end - Oracle JET\\Oracle JET Aplikacija\\Oracle JET - AppKons\\prilozi\\" + fileName + " - " + file2.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file2.getBytes());
        fout.close();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(@RequestParam BigInteger calendarId, @RequestParam BigInteger eventId, @RequestParam String indexNumber) throws IOException {
        Attachment prilog = service.findByScheduledConsultation(calendarId, eventId, indexNumber);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + prilog.getName() + "\"").body(new ByteArrayResource(prilog.getLocation()));
    }

    @GetMapping("/all")
    public @ResponseBody
    Object all() {
        List<AttachmentDTO> allAttachments = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allAttachments);
    }

}
