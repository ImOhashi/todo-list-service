package com.chaosprojectbr.todolistservice.application.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Configuration
public class KafkaAdminConfig {

    private final KafkaProperties kafkaProperties;

    @Value("${spring.kafka.producer.topics.todo-list-topic.name}")
    private String todoListTopicName;

    @Value("${spring.kafka.producer.topics.todo-list-topic.partitions}")
    private int todoListTopicPartitions;

    public KafkaAdminConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();

        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());

        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics newTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder
                        .name(todoListTopicName)
                        .partitions(todoListTopicPartitions)
                        .build()
        );
    }
}
