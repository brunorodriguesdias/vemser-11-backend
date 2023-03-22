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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;



    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        PessoaEntity pessoa = pessoaService.getPessoa(enderecoCreateDTO.getIdPessoa());

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoRepository.save(enderecoEntity);
        pessoaService.adicionarEndereco(enderecoEntity, pessoa);

//        emailService.sendEmail(pessoa, endereco, 1);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
        return enderecoDTO;
    }

    public List<EnderecoDTO> lista () throws RegraDeNegocioException {
        List<EnderecoEntity> enderecoEntityList = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();
        for (EnderecoEntity endereco: enderecoEntityList){
            PessoaEntity pessoa = pessoaService.getPessoaByEndereco(endereco);
            EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
            enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
            enderecoDTOList.add(enderecoDTO);
        }
        return enderecoDTOList;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {

        PessoaEntity pessoa = pessoaService.getPessoa(enderecoAtualizar.getIdPessoa());

        EnderecoEntity enderecoRecuperado = enderecoRepository.getById(id);


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
        pessoaService.adicionarEndereco(enderecoEditado, pessoa);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEditado, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
        return enderecoDTO;
    }

    public List<EnderecoDTO> listaPorPessoa (Integer idPessoa) throws Exception {
        PessoaEntity pessoaEntity = pessoaService.getPessoa(idPessoa);
        List<EnderecoDTO> enderecoDTOList = enderecoRepository.findAllByPessoas(pessoaEntity)
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
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
        PessoaEntity pessoaEntity = pessoaService.getPessoaByEndereco(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(pessoaEntity.getIdPessoa());
        return enderecoDTO;
    }

    public EnderecoEntity getEnderecoById(Integer id) throws Exception {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

    public void delete (Integer idEndereco) throws Exception {
        EnderecoEntity enderecoEntity = getEnderecoById(idEndereco);
//        emailService.sendEmail(pessoaService.getPessoa(enderecoRecuperado.getIdPessoa()), enderecoRecuperado, 3);
        enderecoRepository.delete(enderecoEntity);
    }
}
