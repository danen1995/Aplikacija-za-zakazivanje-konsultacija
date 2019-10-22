package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.serviceImpl.MailNotificationServiceImpl;

@RestController
@CrossOrigin
public class MailNotificationRestController {

    @Autowired
    MailNotificationServiceImpl service;
    
    @RequestMapping("/sendMail")
    public String sendMail(@RequestParam String email) {
        try {
            service.sendNotification(email);
        } catch (MailException e) {
            return "Error while sending the email";
        }
        return "The email was successfully sent.";
    }

}
