package com.dbc.vemser.chatkafka.controller;

import com.dbc.vemser.chatkafka.dto.MensagemDTO;
import com.dbc.vemser.chatkafka.kafka.NomeChat;
import com.dbc.vemser.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @PostMapping("/send-to")
    public void sendTo(@RequestParam List<NomeChat> chats, @RequestParam String mensagem) throws JsonProcessingException {
        for (NomeChat nome : chats) {
            produtorService.enviarMensagem(mensagem, nome);
        }
    }
}