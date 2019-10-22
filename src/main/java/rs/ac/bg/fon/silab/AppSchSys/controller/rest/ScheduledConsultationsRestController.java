package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.service.ScheduledConsultationsService;

@RestController
@RequestMapping("/scheduledConsultations")
@CrossOrigin

public class ScheduledConsultationsRestController {

    @Autowired
    ScheduledConsultationsService service;

    @GetMapping("/student")
    public @ResponseBody
    List<ScheduledConsultationDTO> getScheduledConsultationsForStudent(@RequestParam(value = "indexNumber") String indexNumber) {
        return service.findByIndexNumber(indexNumber);
    }

    @GetMapping("/teacher")
    public @ResponseBody
    List<ScheduledConsultationDTO> getScheduledConsultationsForTeacher(@RequestParam(value = "teacherId") String teacherId) {
        return service.findByTeacherId(teacherId);
    }

    @GetMapping("/event")
    public @ResponseBody
    List<ScheduledConsultationDTO> getAllForEvent(@RequestParam BigDecimal calendarId, @RequestParam BigInteger eventId) {
        return service.getAllForEvent(calendarId, eventId);
    }

    @GetMapping("/get")
    public @ResponseBody
    ScheduledConsultationDTO findById(@RequestParam BigInteger calendarId, @RequestParam BigInteger eventId, @RequestParam String indexNumber) {
        return service.findById(calendarId, eventId, indexNumber);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void deleteScheduledConsultations(@RequestParam BigInteger calendarId, @RequestParam BigInteger eventId, @RequestParam String indexNumber) {
        service.deleteScheduledConsultations(calendarId, eventId, indexNumber);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    Object scheduleConsultation(@RequestBody ScheduledConsultationDTO scheduledConsultationDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.scheduleConsultation(scheduledConsultationDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error. No such student/teacher.");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Object updateConsultation(@RequestBody ScheduledConsultationDTO scheduledConsultationDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateConsultation(scheduledConsultationDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while trying to update consultation.");
        }
    }

}
