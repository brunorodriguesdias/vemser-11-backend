package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
@Slf4j
@Validated
@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController implements ContatoDoc {

    private final ContatoService contatoService;

    public ContatoController (ContatoService contatoService) { this.contatoService = contatoService; }
    @Override
    @GetMapping // GET localhost:8080/contato
    public List<ContatoDTO> list () { return contatoService.list(); }
    @Override
    @GetMapping("/{idPessoa}") // GET localhost:8080/contato/{idPessoa}
    public ResponseEntity<List<ContatoDTO>> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(contatoService.listaPorPessoa(idPessoa), OK);
    }
    @Override
    @PostMapping
    public ResponseEntity<ContatoDTO> create(@RequestBody @Valid ContatoCreateDTO contato) throws Exception {
        log.info("Criando Contato!");
        ContatoDTO contatoCriado = contatoService.create(contato);
        log.info("Contato Criado!");
        return ResponseEntity.ok(contatoCriado);
    }
    @Override
    @PutMapping("/{idContato}") // PUT localhost:8080/contato/{idContato}
    public ContatoDTO update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception {
        log.info("Atualizando contato...");
        return contatoService.update(id, contatoAtualizar);
    }
    @Override
    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        log.info("Deletando contato...");
        contatoService.delete(id);
        log.info("Contato deletado");
        return ResponseEntity.ok().build();
    }
}
