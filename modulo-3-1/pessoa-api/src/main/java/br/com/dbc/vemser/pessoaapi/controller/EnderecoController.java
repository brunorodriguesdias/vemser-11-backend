package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Validated
@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping // GET localhost:8080/endereco
    public List<Endereco> list () { return enderecoService.lista(); }

    @GetMapping("/{idEndereco}") // GET localhost:8080/endereco/{idEndereco}
    public ResponseEntity<Endereco> endereco (@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return new ResponseEntity<>(enderecoService.getEndereco(idEndereco), OK);
    }

    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/endereco/{idPessoa}
    public ResponseEntity<List<Endereco>> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(enderecoService.listaPorPessoa(idPessoa), OK);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/endereco/{idPessoa}
    public Endereco create (@PathVariable Integer idPessoa,
                            @Valid @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(endereco, idPessoa);
    }

    @PutMapping("/{idEndereco}") // POST localhost:8080/endereco/{idEndereco}
    public Endereco update (@PathVariable("idEndereco") Integer idEndereco,
                            @Valid @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(idEndereco, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
        return ResponseEntity.ok().build();
    }
}
