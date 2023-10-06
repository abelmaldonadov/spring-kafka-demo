package amv.springkafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = Map.of(
                TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE,
                TopicConfig.RETENTION_MS_CONFIG, "86400000", // un día en milisegundos
                TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824", // 1 GB en bytes
                TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1048576" // 1MB en bytes
        );

        return TopicBuilder.name("spring-kafka-demo")
                .replicas(3)
                .partitions(3)
                .configs(configurations)
                .build();
    }
}
