package com.notification.strategy;

import org.springframework.stereotype.Component;

@Component("EMAIL")
public class EmailNotification implements NotificationStrategy{

    public void send(String to, String message){
        System.out.println("📧 Email sent to " + to + " | Message: " + message);
    }
}
