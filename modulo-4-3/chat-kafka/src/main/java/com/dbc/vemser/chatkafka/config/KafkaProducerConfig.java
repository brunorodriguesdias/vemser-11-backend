package com.dbc.vemser.chatkafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value(value = "${spring.kafka.properties.security.protocol}")
    private String security;
    @Value(value = "${spring.kafka.properties.sasl.mechanism}")
    private String mechanism;
    @Value(value = "${spring.kafka.properties.enable.idempotence}")
    private boolean idempotence;
    @Value(value = "${spring.kafka.properties.sasl.jaas.config}")
    private String config;

    @Value(value = "${spring.kafka.bootstrap-server}")
    private String bootstrapAddress; //localhost:9092

    @Bean
    public KafkaTemplate<String,String> configKafkaTemplate(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); // servidor
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // chave
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // valor
        configProps.put("sasl.mechanism", mechanism);
        configProps.put("sasl.jaas.config", config);
        configProps.put("security.protocol", security);
        configProps.put("enable.idempotence" , idempotence);
        DefaultKafkaProducerFactory<String, String> kafkaProducerFactory = new DefaultKafkaProducerFactory<>(configProps);
        return new KafkaTemplate<>(kafkaProducerFactory);
    }
}
