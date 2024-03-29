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

    public ContatoDTO create(ContatoCreateDTO contatoDTO, Integer idPessoa) throws Exception {
        contatoDTO.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoDTO, ContatoEntity.class);
        ContatoEntity contato = contatoRepository.create(contatoEntity, idPessoa);
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public List<ContatoDTO> list() {
        return contatoRepository.lista().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        pessoaService.getPessoa(contatoAtualizar.getIdPessoa());
        ContatoEntity contatoRecuperado = getContato(id);
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public List<ContatoDTO> listaPorPessoa (Integer idPessoa) throws Exception {
        List<ContatoEntity> listContato = contatoRepository.listarContatosPorPessoa(idPessoa);
        if (listContato.isEmpty()) {
            throw new RegraDeNegocioException("Pessoa não encontrada");
        }
        List<ContatoDTO> listaDTO = listContato.stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
        return listaDTO;

    }

    private ContatoEntity getContato(Integer id) throws Exception {
        ContatoEntity contatoRecuperado = contatoRepository.lista().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }
}
