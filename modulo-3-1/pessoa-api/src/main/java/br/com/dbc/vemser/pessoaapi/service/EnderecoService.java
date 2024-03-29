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
        EnderecoEntity endereco = enderecoRepository.create(enderecoEntity, idPessoa);

        emailService.sendEmail(pessoa, endereco, 1);

        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public List<EnderecoDTO> lista () {
        return enderecoRepository.lista().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {

        PessoaEntity pessoa = pessoaService.getPessoa(enderecoAtualizar.getIdPessoa());

        EnderecoEntity enderecoRecuperado = getEnderecoById(id);
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        emailService.sendEmail(pessoa, enderecoRecuperado, 2);

        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }

    public List<EnderecoDTO> listaPorPessoa (Integer idPessoa) throws Exception {
        List<EnderecoEntity> listaEnderecos = enderecoRepository.listaEnderecosPorIdPessoa(idPessoa);
        if (listaEnderecos.isEmpty()) {
            throw new RegraDeNegocioException ("Pessoa não encontrada");
        }
        List<EnderecoDTO> listaDTO = listaEnderecos.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }
    public EnderecoDTO getEndereco(Integer id) throws Exception {
        return objectMapper.convertValue(getEnderecoById(id), EnderecoDTO.class);
    }

    public EnderecoEntity getEnderecoById(Integer id) throws Exception {
        return enderecoRepository.lista().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

    public void delete (Integer idEndereco) throws Exception {
        EnderecoEntity enderecoRecuperado = objectMapper.convertValue(getEndereco(idEndereco), EnderecoEntity.class);
        emailService.sendEmail(pessoaService.getPessoa(enderecoRecuperado.getIdPessoa()), enderecoRecuperado, 3);
        enderecoRepository.delete(enderecoRecuperado);
    }
}
