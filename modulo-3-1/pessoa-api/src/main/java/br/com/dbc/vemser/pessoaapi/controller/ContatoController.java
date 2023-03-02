package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Validated
@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController (ContatoService contatoService) { this.contatoService = contatoService; }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list () { return contatoService.list(); }

    @GetMapping("/{idPessoa}") // GET localhost:8080/contato/{idPessoa}
    public ResponseEntity<List<Contato>> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(contatoService.listaPorPessoa(idPessoa), OK);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/contato/{idPessoa}
    public Contato create(@PathVariable Integer idPessoa,
                          @Valid @RequestBody Contato contato) throws Exception {
        return contatoService.create(contato, idPessoa);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/contato/{idContato}
    public Contato update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
