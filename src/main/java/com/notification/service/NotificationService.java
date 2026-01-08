package com.notification.service;

import com.notification.factory.NotificationFactory;
import com.notification.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void send(String type, String to, String message) {
        NotificationStrategy strategy =
                notificationFactory.getNotificationStrategy(type);

        strategy.send(to, message);
    }
}
