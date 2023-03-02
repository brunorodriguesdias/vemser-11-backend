package br.com.dbc.vemser.pessoaapi.service;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;

    public ContatoService (ContatoRepository contatoRepository, PessoaService pessoaService) {
        this.pessoaService = pessoaService;
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        return contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> list() { return contatoRepository.lista(); }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = getContato(id);

        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return contatoRecuperado;
    }

    public List<Contato> listaPorPessoa (Integer idPessoa) throws Exception {
        List<Contato> listContato = contatoRepository.listarContatosPorPessoa(idPessoa);
        if (listContato.isEmpty()) {
            throw new Exception("Pessoa não encontrada");
        }
        return listContato;

    }

    private Contato getContato(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.lista().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado!"));
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }
}
