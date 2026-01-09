package com.notification.controller;

import com.notification.dto.NotificationRequest;
import com.notification.service.NotificationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(consumes = "application/json")
    public String sendNotification(
            @Validated @RequestBody NotificationRequest request) {

        notificationService.send(
                request.getType(),
                request.getTo(),
                request.getMessage()
        );

        return "Notification Sent Successfully";
    }

    @PostMapping("/email/pdf")
    public String sendEmailWithPdf(
            @RequestBody NotificationRequest request
    ) {
        notificationService.sendEmailWithPdf(
                request.getTo(),
                request.getMessage()
        );
        return "Email with PDF sent";
    }

}
