package br.com.adriane.kafka.atleastonce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "at.least.once.topic")
    public void listen(String message) throws InterruptedException {
        log.info("Message received={}",message);
    }

}
