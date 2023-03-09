package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Validated
@RestController("/dados-pessoais")
@RequestMapping
@RequiredArgsConstructor
public class DadosPessoaisController implements DadosPessoaisDoc{
    private final DadosPessoaisService dadosPessoaisService;
//    @Override
    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> getAll() {
        return new ResponseEntity<>(dadosPessoaisService.getAll(), OK);
    }
    @Override
    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> getCpf(@PathVariable String cpf) throws Exception {
        return new ResponseEntity<>(dadosPessoaisService.get(cpf), OK);
    }
    @Override
    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return new ResponseEntity<>(dadosPessoaisService.post(dadosPessoaisDTO), OK);
    }
    @Override
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable String cpf,
                                                @Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return new ResponseEntity<>(dadosPessoaisService.put(cpf, dadosPessoaisDTO), OK);
    }
    @Override
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) throws Exception {
        dadosPessoaisService.delete(cpf);
        return ResponseEntity.ok().build();
    }


}
