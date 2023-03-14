package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        pessoaEntity = pessoaRepository.save(pessoaEntity);

//        emailService.sendEmail(pessoaEntity, 1);

        PessoaDTO pessoa = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        return pessoa;
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizarDTO) throws Exception {
        PessoaEntity pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizarDTO.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizarDTO.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizarDTO.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizarDTO.getEmail());

        pessoaRecuperada = pessoaRepository.save(pessoaRecuperada);

//        emailService.sendEmail(pessoaRecuperada, 2);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = getPessoa(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
//        emailService.sendEmail(pessoa, 3);
        pessoaRepository.deleteById(pessoaRecuperada.getIdPessoa());
    }

    public List<PessoaDTO> listByName(String nome) throws RegraDeNegocioException {
//        List<PessoaEntity> pessoaList = pessoaRepositoryOld.listByName(nome);
        List<PessoaDTO> pessoaList = new ArrayList<>();
        if (pessoaList.isEmpty()) {
            throw new RegraDeNegocioException("Nenhuma pessoa encontrada com o nome: " + nome.toUpperCase());
        }
        return pessoaList;
    }

    public PessoaEntity getPessoa(Integer id) throws RegraDeNegocioException {
//        PessoaEntity pessoaRecuperada = pessoaRepository.list().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
//                .findFirst()

        PessoaEntity pessoaRecuperada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
}
