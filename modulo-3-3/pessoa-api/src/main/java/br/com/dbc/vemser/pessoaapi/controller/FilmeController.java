package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaXFilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaXFilmeDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.FilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Slf4j
@Validated
@RestController
@RequestMapping("/filme")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public List<FilmeDTO> list() { return filmeService.list(); }

    @GetMapping("/{idFilme}")
    public ResponseEntity<FilmeDTO> findById(@PathVariable("idFilme") Integer idFilme) throws RegraDeNegocioException {
        return new ResponseEntity<>(filmeService.getFilmeDTO(idFilme), OK);
    }

    @PostMapping
    public FilmeDTO create (@Valid @RequestBody FilmeCreateDTO filmeCreateDTO) {
        log.info("Criando filme...");
        return filmeService.create(filmeCreateDTO);
    }

    @PutMapping("/{idFilme}")
    public FilmeDTO update(@PathVariable("idFilme") Integer idFilme,
                           @Valid @RequestBody FilmeCreateDTO filmeCreateDTO) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        return filmeService.update(idFilme, filmeCreateDTO);
    }

    @DeleteMapping("/{idFilme}")
    public ResponseEntity<Void> delete(@PathVariable("idFilme") Integer idFilme) throws RegraDeNegocioException {
        log.info("Deletando filme...");
        filmeService.delete(idFilme);
        log.info("Filme deletado!");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/avaliar-filme/{idPessoa}")
    public ResponseEntity<PessoaXFilmeDTO> avaliar(@PathVariable("idPessoa") Integer idPessoa,
                                                   @Valid @RequestBody PessoaXFilmeCreateDTO pessoaXFilmeCreateDTO) {
        return new ResponseEntity<>(filmeService.createAvaliacao(idPessoa, pessoaXFilmeCreateDTO), OK);
    }
}
