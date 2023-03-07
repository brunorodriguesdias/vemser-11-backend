package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Slf4j
@Validated
@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController implements EnderecoDoc {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
    @Override
    @GetMapping // GET localhost:8080/endereco
    public List<EnderecoDTO> list () { return enderecoService.lista(); }
    @Override
    @GetMapping("/{idEndereco}") // GET localhost:8080/endereco/{idEndereco}
    public ResponseEntity<EnderecoDTO> endereco (@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return new ResponseEntity<>(enderecoService.getEndereco(idEndereco), OK);
    }
    @Override
    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/endereco/{idPessoa}
    public ResponseEntity<List<EnderecoDTO>> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(enderecoService.listaPorPessoa(idPessoa), OK);
    }
    @Override
    @PostMapping("/{idPessoa}") // POST localhost:8080/endereco/{idPessoa}
    public EnderecoDTO create (@PathVariable Integer idPessoa,
                            @Valid @RequestBody EnderecoCreateDTO enderecoDTO) throws Exception {
        log.info("Criando endereço...");
        return enderecoService.create(enderecoDTO, idPessoa);
    }
    @Override
    @PutMapping("/{idEndereco}") // POST localhost:8080/endereco/{idEndereco}
    public EnderecoDTO update (@PathVariable("idEndereco") Integer idEndereco,
                            @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
        log.info("Atualizando endereço...");
        return enderecoService.update(idEndereco, enderecoAtualizar);
    }
    @Override
    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        log.info("Deletando endereço...");
        enderecoService.delete(idEndereco);
        log.info("Endereço deletado");
        return ResponseEntity.ok().build();
    }
}
