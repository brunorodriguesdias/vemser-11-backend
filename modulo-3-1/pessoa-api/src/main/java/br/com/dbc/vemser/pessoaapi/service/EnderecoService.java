package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;


    public EnderecoService (EnderecoRepository enderecoRepository, PessoaService pessoaService) {
        this.pessoaService = pessoaService;
        this.enderecoRepository = enderecoRepository; }

    public Endereco create(Endereco endereco, Integer idPessoa) throws Exception {
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        return enderecoRepository.create(endereco, idPessoa);
    }

    public List<Endereco> lista () { return enderecoRepository.lista(); }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(id);

        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public List<Endereco> listaPorPessoa (Integer idPessoa) throws Exception {
        List<Endereco> listaEnderecos = enderecoRepository.listaEnderecosPorIdPessoa(idPessoa);
        if (listaEnderecos.isEmpty()) {
            throw new Exception ("Pessoa não encontrada");
        }
        return listaEnderecos;
    }
    public Endereco getEndereco(Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.lista().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado!"));
        return enderecoRecuperado;
    }

    public void delete (Integer idEndereco) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);
        enderecoRepository.delete(enderecoRecuperado);
    }
}
