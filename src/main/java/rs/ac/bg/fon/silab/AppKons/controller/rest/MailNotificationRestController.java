package rs.ac.bg.fon.silab.AppKons.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        } catch (MailException e) {
            return "Greska u slanju mejla";
        }
        return "Uspesno poslat mejl.";
    }

}
