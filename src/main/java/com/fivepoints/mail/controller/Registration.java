package com.fivepoints.mail.controller;

import com.fivepoints.mail.Domain.User;
import com.fivepoints.mail.service.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registration {

    private Logger logger = LoggerFactory.getLogger(Registration.class);
    @Autowired
    Notification notification;
    @RequestMapping("/signup")
    public String signup(){
        return "Please signup";
    }
    @RequestMapping("/signup-success")
    public String signin(){
        //creating a user
        User user = new User();
        user.setEmailAddress("anouaraouini1571@gmail.com");
        user.setFirstName("Anouar");
        user.setLastName("Aouini");
        // send a notification
        try{
            notification.sendNotification(user);
        }catch(MailException e){
          logger.info("Error sending email " + e.getMessage());
        }
        return "Thank you for registring with us";
    }
}
