package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<EnderecoEntity> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository(PessoaService pessoaService) {

        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),1, TipoEndereco.ofTipo(2), "Quinze de Novembro", 6915, "Conjunto 9", "62934591",  "Palmas", "TO", "Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),2, TipoEndereco.ofTipo(1), "General Anápio Gomes", 1081, "APTO 302", "94920270",  "Cachoeirinha", "RS", "Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),3, TipoEndereco.ofTipo(2), "Maranhão", 475, "CASA FUNDOS", "69327861",  "Brasília", "DF", "Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),4, TipoEndereco.ofTipo(1), "Santa Rita", 318, "APTO 101", "29720630",  "Recife", "Pernanbuco", "Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),5, TipoEndereco.ofTipo(2), "São Jorge", 984,null, "87500727",  "Jataí", "GO", "Brasil"));
    }

    public List<EnderecoEntity> lista () { return listaEnderecos; }

    public EnderecoEntity create(EnderecoEntity endereco, Integer idPessoa) throws Exception {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public void delete (EnderecoEntity endereco) { listaEnderecos.remove(endereco); }

    public List<EnderecoEntity> listaEnderecosPorIdPessoa (Integer idPessoa) {
        List<EnderecoEntity> listaConsulta = new ArrayList<>();
        listaConsulta = listaEnderecos.stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        return listaConsulta;
    }
}
