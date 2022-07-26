package br.com.adriane.kafka.atleastonce;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "at.least.once.topic")
    public void listener(ConsumerRecord<String, String> message, Acknowledgment ack) {
        log.info("Message received={}, offset={}, partition={}",message.value(), message.offset(), message.partition());
        ack.acknowledge();
    }

}
