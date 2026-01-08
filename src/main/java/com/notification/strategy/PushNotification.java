package com.notification.strategy;

import org.springframework.stereotype.Component;

@Component("PUSH")
public class PushNotification implements NotificationStrategy{

    public void send(String to, String message) {
        System.out.println("🔔 Push notification sent to " + to + " | Message: " + message);
    }
}
