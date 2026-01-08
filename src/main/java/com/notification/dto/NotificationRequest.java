package com.notification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
    private String type;

    private String to;

    private String message;
}

