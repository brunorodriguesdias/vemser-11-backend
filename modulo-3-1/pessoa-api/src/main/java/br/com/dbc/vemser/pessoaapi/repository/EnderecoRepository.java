package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    private final PessoaService pessoaService;

    public EnderecoRepository(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.ofTipo(2), "Quinze de Novembro", 6915, "Conjunto 9", "62934-591",  "Palmas", "TO", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),2, TipoEndereco.ofTipo(1), "General Anápio Gomes", 1081, "APTO 302", "94920-270",  "Cachoeirinha", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),3, TipoEndereco.ofTipo(2), "Maranhão", 475, "CASA FUNDOS", "69327-861",  "Brasília", "DF", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),4, TipoEndereco.ofTipo(1), "Santa Rita", 318, "APTO 101", "29720-630",  "Recife", "Pernanbuco", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),5, TipoEndereco.ofTipo(2), "São Jorge", 984, "87500-727",  "Jataí", "GO", "Brasil"));
    }

    public List<Endereco> lista () { return listaEnderecos; }

    public Endereco create(Endereco endereco, Integer idPessoa) throws Exception {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public void delete (Endereco endereco) { listaEnderecos.remove(endereco); }

    public List<Endereco> listaEnderecosPorIdPessoa (Integer idPessoa) {
        List<Endereco> listaConsulta = new ArrayList<>();
        listaConsulta = listaEnderecos.stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        return listaConsulta;
    }
}
