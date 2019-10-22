/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dane
 */
@Service
public class MailNotificationServiceImpl {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailNotificationServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(String email) throws MailException{
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("Consultation.fon@gmail.com");
        mail.setText("Otkazan je termin Consultation koje ste zakazali. Proverite sajt za detalje. Pozdrav.");
        mail.setSubject("Otkazan termin konsultacija");
        javaMailSender.send(mail);
    }
}
