package rs.ac.bg.fon.silab.AppKons.controller.rest;

import java.math.BigDecimal;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppKons.dto.KalendarDTO;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.dto.UserDTO;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.KalendarServiceImpl;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.KorisnickiNalogServiceImpl;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.MailNotificationServiceImpl;

@RestController
@CrossOrigin

public class MailNotificationRestController {

    @Autowired
    MailNotificationServiceImpl service;

    @RequestMapping("/posaljimail")
    public String posaljiMejl(@RequestParam String email) {
        try {
            service.sendNotification(email);
        }catch(MailException e){
            return "Greska u slanju mejla";
        }
        return "Uspesno poslat mejl.";
    }

}
