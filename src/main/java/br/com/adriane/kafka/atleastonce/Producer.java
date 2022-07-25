package br.com.adriane.kafka.atleastonce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        log.info("Message sent={}", message);
        kafkaTemplate.send("at.least.once.topic", message)
            .addCallback(
            result -> log.info("partition={}, offset={}", result.getRecordMetadata().partition(), result.getRecordMetadata().offset()),
            ex -> log.error("Unable to send message=[{}] due to : {}", message, ex.getMessage())
        );
    }

}
