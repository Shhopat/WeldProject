package com.svar_proekt.weldproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;
    //Обертка на KafkaTemplate. Нужен для отправки события в Kafka в форме key/value

    public void send(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
        //отправка событий

    }

}
