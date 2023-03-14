package br.com.dbc.vemser.pessoaapi.service;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO, Integer idPessoa) throws Exception {
//        contatoCreateDTO.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);

        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
//        pessoaService.getPessoa(contatoAtualizar.getIdPessoa());
        ContatoEntity contatoRecuperado = getContato(id);
//        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        ContatoEntity contatoEntity = contatoRepository.save(contatoRecuperado);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }

//    public List<ContatoDTO> listaPorPessoa (Integer idPessoa) throws Exception {
//        List<ContatoEntity> listContato = contatoRepository.listarContatosPorPessoa(idPessoa);
//        if (listContato.isEmpty()) {
//            throw new RegraDeNegocioException("Pessoa não encontrada");
//        }
//        List<ContatoDTO> listaDTO = listContato.stream()
//                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
//                .collect(Collectors.toList());
//        return listaDTO;
//    }

    private ContatoEntity getContato(Integer id) throws Exception {
        ContatoEntity contatoRecuperado = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoRecuperado = getContato(id);
        contatoRepository.deleteById(contatoRecuperado.getIdContato());
    }
}
