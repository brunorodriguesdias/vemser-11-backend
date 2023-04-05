package com.dbc.vemser.chatkafka.service;

import com.dbc.vemser.chatkafka.dto.MensagemDTO;
import com.dbc.vemser.chatkafka.kafka.NomeChat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutorService {

    @Value(value = "${kafka.topic}")
    private String topico;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarMensagem(String mensagem, NomeChat nomeChat) throws JsonProcessingException {
        String mensagemDTO = objectMapper.writeValueAsString(new MensagemDTO("BRUNO", mensagem, LocalDateTime.now()));
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagemDTO)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        if (nomeChat != null) {
            stringMessageBuilder
                    .setHeader(KafkaHeaders.PARTITION_ID, nomeChat.getParticao());
        }
        Message<String> message = stringMessageBuilder.build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", message);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", message, ex);
            }
        });
    }
}
