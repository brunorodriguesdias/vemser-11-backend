package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController () { contatoService = new ContatoService(); }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list () { return contatoService.list(); }

    @GetMapping("/{idPessoa}") // GET localhost:8080/contato/{idPessoa}
    public List<Contato> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listaPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/contato/{idPessoa}
    public Contato create(@PathVariable Integer idPessoa,
                          @RequestBody Contato contato) throws Exception {
        PessoaService pessoaService = new PessoaService();
        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/contato/{idContato}
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/{idContato}
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
