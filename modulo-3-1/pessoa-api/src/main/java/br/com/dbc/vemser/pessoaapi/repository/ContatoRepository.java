package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    private final PessoaService pessoaService;

    public ContatoRepository(PessoaService pessoaService){
        this.pessoaService = pessoaService;
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.ofTipo(1), "51-99999-8888", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.ofTipo(2), "51-99999-7777", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.ofTipo(1), "51-99999-6666", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, TipoContato.ofTipo(2), "51-99999-5555", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, TipoContato.ofTipo(1), "51-99999-4444", "Celular"));
    }

    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> lista () { return listaContatos; }

    public List<Contato> listarContatosPorPessoa (Integer idPessoa) {
        List<Contato> listaConsulta = new ArrayList<>();
        listaConsulta = listaContatos.stream().filter(contato -> contato.getIdPessoa().equals(idPessoa))
                 .collect(Collectors.toList());
         return listaConsulta;
    }

    public void delete (Contato contato) { listaContatos.remove(contato); }

}
