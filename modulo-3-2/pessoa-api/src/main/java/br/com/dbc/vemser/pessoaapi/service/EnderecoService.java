package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;



    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO, Integer idPessoa) throws Exception {
        PessoaEntity pessoa = pessoaService.getPessoa(idPessoa);
        enderecoCreateDTO.setIdPessoa(pessoa.getIdPessoa());

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(enderecoEntity);

//        emailService.sendEmail(pessoa, endereco, 1);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        return enderecoDTO;
    }

    public List<EnderecoDTO> lista () {
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {

        PessoaEntity pessoa = pessoaService.getPessoa(enderecoAtualizar.getIdPessoa());

        EnderecoEntity enderecoRecuperado = enderecoRepository.getById(id);

//        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

//        emailService.sendEmail(pessoa, enderecoRecuperado, 2);
        EnderecoEntity enderecoEditado = enderecoRepository.save(enderecoRecuperado);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEditado, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> listaPorPessoa (Integer idPessoa) throws Exception {
        PessoaEntity pessoaEntity = pessoaService.getPessoa(idPessoa);
        List<EnderecoDTO> enderecoDTOList = enderecoRepository.findAllByPessoa(pessoaEntity)
                .stream()
                .map(enderecoEntity -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(pessoaEntity.getIdPessoa());
                    return enderecoDTO;
                })
                .toList();
        return enderecoDTOList;
    }
    public EnderecoDTO getEndereco(Integer id) throws Exception {
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.findById(id), EnderecoDTO.class);
        return enderecoDTO;
    }

    public EnderecoEntity getEnderecoById(Integer id) throws Exception {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

    public void delete (Integer idEndereco) throws Exception {
        EnderecoEntity enderecoEntity = getEnderecoById(idEndereco);
//        emailService.sendEmail(pessoaService.getPessoa(enderecoRecuperado.getIdPessoa()), enderecoRecuperado, 3);
        enderecoRepository.deleteById(enderecoEntity.getIdEndereco());
    }
}
