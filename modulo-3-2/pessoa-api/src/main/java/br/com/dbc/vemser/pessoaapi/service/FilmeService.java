package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaPK;
import br.com.dbc.vemser.pessoaapi.entity.PessoaXFilmeEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.FilmeRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaXFilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final ObjectMapper objectMapper;
    private final PessoaXFilmeRepository pessoaXFilmeRepository;

    public FilmeDTO create(FilmeCreateDTO filmeCreateDTO) {

        FilmeEntity filmeEntity = objectMapper.convertValue(filmeCreateDTO, FilmeEntity.class);

        FilmeEntity filmeCriado = filmeRepository.save(filmeEntity);

        FilmeDTO filmeDTO = objectMapper.convertValue(filmeCriado, FilmeDTO.class);
        return filmeDTO;
    }

    public List<FilmeDTO> list() {
        return filmeRepository.findAll()
                .stream()
                .map(filme -> objectMapper.convertValue(filme, FilmeDTO.class))
                .collect(Collectors.toList());
    }

    public FilmeDTO update(Integer id, FilmeCreateDTO filmeCreateDTO) throws RegraDeNegocioException {
        FilmeEntity filmeRecuperado = getFilme(id);
        filmeRecuperado.setDescricao(filmeCreateDTO.getDescricao());
        filmeRecuperado.setNota(filmeCreateDTO.getNota());
        filmeRecuperado.setTipo(filmeCreateDTO.getTipo());

        FilmeEntity filmeEntity = filmeRepository.save(filmeRecuperado);

        FilmeDTO filmeDTO = objectMapper.convertValue(filmeEntity, FilmeDTO.class);
        return filmeDTO;
    }

    public FilmeEntity getFilme(Integer id) throws RegraDeNegocioException {
        FilmeEntity filmeRecuperado = filmeRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Filme não encontrado"));
        return filmeRecuperado;
    }

    public FilmeDTO getFilmeDTO(Integer id) throws RegraDeNegocioException {
        FilmeEntity filmeRecuperado = getFilme(id);
        FilmeDTO filmeDTO = objectMapper.convertValue(filmeRecuperado, FilmeDTO.class);
        return filmeDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        FilmeEntity filmeRecuperado = getFilme(id);
        filmeRepository.deleteById(id);
    }

    public PessoaXFilmeDTO createAvaliacao (Integer idPessoa, PessoaXFilmeCreateDTO pessoaXFilmeCreateDTO) {
        PessoaXFilmeEntity pessoaXFilmeEntity = objectMapper.convertValue(pessoaXFilmeCreateDTO, PessoaXFilmeEntity.class);
        PessoaPK pessoaPK = new PessoaPK();
        pessoaPK.setIdPessoa(idPessoa);
        pessoaPK.setIdFilme(pessoaXFilmeCreateDTO.getIdFilme());
        pessoaXFilmeEntity.setPessoaPK(pessoaPK);
        PessoaXFilmeEntity pessoaXFilmeCriado = pessoaXFilmeRepository.save(pessoaXFilmeEntity);

        PessoaXFilmeDTO pessoaXFilmeDTO = objectMapper.convertValue(pessoaXFilmeEntity, PessoaXFilmeDTO.class);
        return pessoaXFilmeDTO;
    }

}
