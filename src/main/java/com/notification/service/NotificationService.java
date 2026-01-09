package com.notification.service;

import com.notification.factory.NotificationFactory;
import com.notification.strategy.EmailNotification;
import com.notification.strategy.NotificationStrategy;
import com.notification.utility.PdfGenerator;
import org.springframework.stereotype.Service;

import java.io.File;

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

    public void sendEmailWithPdf(
            String to,
            String message
    ) {
        NotificationStrategy strategy =
                notificationFactory.getNotificationStrategy("EMAIL");

        if (!(strategy instanceof EmailNotification email)) {
            throw new IllegalStateException("EMAIL strategy not configured");
        }
        File pdf = PdfGenerator.generateSimplePdf(message).toFile();

        email.sendWithAttachment(to, message, pdf);
    }
}
