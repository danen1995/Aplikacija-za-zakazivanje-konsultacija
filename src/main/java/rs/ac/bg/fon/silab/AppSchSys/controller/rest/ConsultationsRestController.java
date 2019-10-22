package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import rs.ac.bg.fon.silab.AppSchSys.dto.ConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.service.ConsultationsService;

@RestController
@RequestMapping("/consultations")
@CrossOrigin
public class ConsultationsRestController {

    @Autowired
    ConsultationsService service;

    @GetMapping("/all")
    public @ResponseBody
    Object getAllConsultations() {
        List<ConsultationDTO> allConsultations = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allConsultations);
    }

    @GetMapping("/teacher")
    public @ResponseBody
    Object getConsultationsForTeacher(@RequestParam(value = "teacherId") String teacherId) {
        List<ConsultationDTO> teacherConsultations = service.getConsultationsForTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(teacherConsultations);
    }

    @GetMapping("/fromTeachersCalendar")
    public @ResponseBody
    Object getConsultationsFromTeachersCalendar(@RequestParam(value = "teacherId") String teacherId, @RequestParam(value = "calendarId") BigDecimal calendarId) {
        List<ConsultationDTO> consultationsFromTeachersCal = service.getConsultationsFromTeachersCalendar(teacherId, calendarId);
        return ResponseEntity.status(HttpStatus.OK).body(consultationsFromTeachersCal);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CrossOrigin
    public @ResponseBody
    Object generateConsultation(@RequestBody ConsultationDTO consultationDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.generateConsultation(consultationDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + ex.getCause() + ex.getStackTrace());
        }
    }

    @RequestMapping(value = "/ispis", method = RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Object generateConsultationList(@RequestParam Integer dan,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datumOd,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datumDo
    ) {
        try {
            List<String> lista = new ArrayList<>();
            Calendar start = Calendar.getInstance();
            start.setTime(datumOd);
            Calendar end = Calendar.getInstance();
            end.setTime(datumDo);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                if (date.getDay() == dan) {
                    lista.add(df.format(date));
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(lista);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greska.");
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void deleteConsultations(@RequestParam BigInteger calendarId, @RequestParam BigInteger eventId) {
        service.deleteConsultations(calendarId, eventId);
    }
}
