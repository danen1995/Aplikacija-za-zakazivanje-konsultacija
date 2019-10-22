package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.dto.CalendarDTO;
import rs.ac.bg.fon.silab.AppSchSys.service.CalendarService;

@RestController
@CrossOrigin
@RequestMapping("/calendar")
public class CalendarRestController {

    @Autowired
    CalendarService service;

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public @ResponseBody
    Object getCalendarsForTeacher(@RequestParam String teacherId) {
        List<CalendarDTO> calendarsDTO = service.getCalendarsForTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(calendarsDTO);
    }

}
