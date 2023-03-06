package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;

    public PessoaController(PessoaService pessoaService, PropertieReader propertieReader) {
        this.pessoaService = pessoaService;
        this.propertieReader = propertieReader;
    }

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/ambiente") // GET localhost:8080/pessoa/ambiente
    public String ambiente() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") @NotBlank String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), OK);
    }

    @PostMapping // POST localhost:8080/pessoa
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoaDTO) throws Exception {
        log.info("Criando pessoa...");
        return pessoaService.create(pessoaDTO);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @Valid @RequestBody PessoaDTO pessoaDTOAtualizar) throws Exception {
        log.info("Atualizando pessoa...");
        return pessoaService.update(id, pessoaDTOAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando pessoa...");
        pessoaService.delete(id);
        log.info("Pessoa deletada!");
        return ResponseEntity.ok().build();
    }
}
