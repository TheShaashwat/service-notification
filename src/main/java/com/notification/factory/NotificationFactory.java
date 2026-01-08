package com.notification.factory;

import com.notification.strategy.NotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationFactory {

    private final Map<String, NotificationStrategy> strategyMap;

    public NotificationFactory(Map<String, NotificationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public NotificationStrategy getNotificationStrategy(String type) {
        NotificationStrategy strategy = strategyMap.get(type.toUpperCase());

        if (strategy == null) {
            throw new IllegalArgumentException("Invalid Notification Type: " + type);
        }
        return strategy;
    }
}
