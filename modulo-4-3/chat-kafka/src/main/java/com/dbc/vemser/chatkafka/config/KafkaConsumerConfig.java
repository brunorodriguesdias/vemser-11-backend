package com.dbc.vemser.chatkafka.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    private static final String EARLIEST = "earliest";
    private static final String LATEST = "latest";

    @Value(value = "${spring.kafka.bootstrap-server}")
    private String bootstrapServer;

    @Value(value = "${spring.kafka.properties.security.protocol}")
    private String security;
    @Value(value = "${spring.kafka.properties.sasl.mechanism}")
    private String mechanism;
    @Value(value = "${spring.kafka.properties.enable.idempotence}")
    private boolean idempotence;
    @Value(value = "${spring.kafka.properties.sasl.jaas.config}")
    private String config;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory1() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "bruno");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
        props.put("sasl.mechanism", mechanism);
        props.put("sasl.jaas.config", config);
        props.put("security.protocol", security);
        props.put("enable.idempotence" , idempotence);
        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory
                = new DefaultKafkaConsumerFactory<>(props);

        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory2() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "BRUNO");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, LATEST);
        props.put("sasl.mechanism", mechanism);
        props.put("sasl.jaas.config", config);
        props.put("security.protocol", security);
        props.put("enable.idempotence" , idempotence);
        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory
                = new DefaultKafkaConsumerFactory<>(props);

        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory);
        return factory;
    }
}