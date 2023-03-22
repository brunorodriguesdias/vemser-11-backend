package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import feign.Client;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DadosPessoaisService implements DadosPessoaisClient {
    private final DadosPessoaisClient client;
    @Override
    public List<DadosPessoaisDTO> getAll() {
        return client.getAll();
    }

    @Override
    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return client.post(dadosPessoaisDTO);
    }

    @Override
    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return client.put(cpf, dadosPessoaisDTO);
    }
    @Override
    public void delete(String cpf) {
        client.delete(cpf);
    }

    @Override
    public DadosPessoaisDTO get(String cpf) {
        return client.get(cpf);
    }
}
