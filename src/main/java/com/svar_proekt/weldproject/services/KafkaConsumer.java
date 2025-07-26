package com.svar_proekt.weldproject.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group", concurrency = "2")
    public void listen(String message) {
        System.out.println("Получено сообщение: " + message);
    }
}
