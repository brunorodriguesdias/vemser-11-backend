package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Endereco endereco (@PathVariable("idEndereco") Integer idEndereco) throws Exception { return enderecoService.getEndereco(idEndereco); }

    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/endereco/{idPessoa}
    public List<Endereco> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.listaPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/endereco/{idPessoa}
    public Endereco create (@PathVariable Integer idPessoa,
                            @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(endereco, idPessoa);
    }

    @PutMapping("/{idEndereco}") // POST localhost:8080/endereco/{idEndereco}
    public Endereco update (@PathVariable("idEndereco") Integer idEndereco,
                            @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(idEndereco, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
    public void delete (@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }
}
