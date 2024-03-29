package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaDTO) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaDTO, PessoaEntity.class);
        PessoaEntity pessoa = pessoaRepository.create(pessoaEntity);

        emailService.sendEmail(pessoa, 1);

        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizarDTO) throws Exception {
        PessoaEntity pessoaRecuperada = getPessoa(id);
        pessoaRecuperada.setCpf(pessoaAtualizarDTO.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizarDTO.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizarDTO.getDataNascimento());

        emailService.sendEmail(pessoaRecuperada, 2);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoa = getPessoa(id);
        PessoaEntity pessoaRecuperada = getPessoa(id);
        emailService.sendEmail(pessoa, 3);
        pessoaRepository.delete(pessoaRecuperada);

    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaEntity getPessoa(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
}
