package amv.springkafkaconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@Slf4j
public class KafkaConsumerListener {

    @KafkaListener(topics = "spring-kafka-demo", groupId = "spring-kafka-demo")
    public void listener(@Payload String message) {
        log.info("Mensaje recibido. El mensaje es: " + message);
    }
}
