package com.dbc.vemser.chatkafka.service;

import com.dbc.vemser.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})},
            containerFactory = "listenerContainerFactory1"
    )
    public void lerMensagemGeral(@Payload String mensagem, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) throws JsonProcessingException {
        String saidaFormatada = formatarSaida("%d/%d/%d %d:%d:%d [%s](geral): %s", mensagem);
        log.info(saidaFormatada);
    }
    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"1"})},
            containerFactory = "listenerContainerFactory2"
    )
    public void lerMensagemPrivada(@Payload String mensagem, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) throws JsonProcessingException {
        String saidaFormatada = formatarSaida("%d/%d/%d %d:%d:%d [%s](privada): %s", mensagem);
        log.info(saidaFormatada);
    }

    private String formatarSaida(String format, String mensagem) throws JsonProcessingException {
        try {
            MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
            LocalDateTime dataCriacao = mensagemDTO.getDataCriacao();

            String saidaFormatada = String.format(format,
                    dataCriacao.getDayOfMonth(), dataCriacao.getMonthValue(), dataCriacao.getYear(),
                    dataCriacao.getHour(), dataCriacao.getMinute(), dataCriacao.getSecond(),
                    mensagemDTO.getUsuario(), mensagemDTO.getMensagem());
            return saidaFormatada;
        } catch (JsonProcessingException ex) {
            log.info("Erro ao ler mensagem");
            return null;
        }
    }
}
