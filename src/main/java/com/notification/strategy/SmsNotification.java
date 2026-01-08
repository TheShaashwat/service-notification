package com.notification.strategy;

import org.springframework.stereotype.Component;

@Component("SMS")
public class SmsNotification implements NotificationStrategy{

    public void send(String to, String message) {
        System.out.println("📱 SMS sent to " + to + " | Message: " + message);
    }
}
