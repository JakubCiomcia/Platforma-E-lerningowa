package com.example.userservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventListener {
    @RabbitListener(queues = "user.events")
    public void handleUserEvent(String message) {
        System.out.println("Received User Event: " + message);
    }
}
