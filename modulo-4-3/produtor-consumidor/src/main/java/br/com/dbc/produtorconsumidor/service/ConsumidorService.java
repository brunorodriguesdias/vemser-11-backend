package br.com.dbc.produtorconsumidor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumidorService {

    @KafkaListener(
            topics = "${kafka.topico}", // caixa-de-correio
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void lerMensagem(@Payload String message,
                                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                                  @Header(KafkaHeaders.OFFSET) Long offset){
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }
}
