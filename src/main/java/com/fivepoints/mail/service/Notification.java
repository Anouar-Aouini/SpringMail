package com.fivepoints.mail.service;

import com.fivepoints.mail.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Notification {
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    public Notification (JavaMailSenderImpl javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(User user){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("mohamedaziz.sahnoun@esprit.tn");
        mail.setText("Some text content ...");
        mail.setSubject("Some subject content ...");
        Properties props = new Properties();
        props.setProperty("spring.mail.smtp.starttls.enable", "true");
        props.setProperty("spring.mail.smtp.ssl.protocols", "TLSv1.2");
        javaMailSender.send(mail);
    }
}
