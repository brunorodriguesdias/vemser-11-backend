package br.com.dbc.produtorconsumidor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutorService {

    @Value(value = "${kafka.topico}")
    private String topico;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(String mensagem) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());

//        kafkaTemplate.send(stringMessageBuilder.build());
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessageBuilder.build());
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar no kafka a mensagem: {}", mensagem, ex);
            }

            @Override
            public void onSuccess(SendResult result) {
                log.info("Log enviado para o kafka com o texto: {} ", mensagem);
            }
        });
    }
}
