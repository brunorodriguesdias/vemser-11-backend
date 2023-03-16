package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaComTodasRelacoesDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//public interface PessoaRepository extends JpaRepository<ENTIDADE,TIPODOMEUID>

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);

    Optional<PessoaEntity> findByCpf(String cpf);

    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);

    List<PessoaEntity> findByEnderecos(EnderecoEntity enderecoEntity);

    @Query("select new br.com.dbc.vemser.pessoaapi.dto.PessoaComTodasRelacoesDTO" +
            "(p.idPessoa, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "ep.cep, " +
            "ep.cidade, " +
            "ep.estado, " +
            "ep.pais, " +
            "pets.nomePet, " +
            "pxf.descricao, " +
            "av.descricaoPessoa, " +
            "av.dtAssistido, " +
            "av.notaPessoa, " +
            "pxf.nota) " +
            "from PESSOA p " +
            "left join p.avaliacoes av " +
            "left join av.filme pxf " +
            "left join p.pets pets " +
            "left join p.contatos c " +
            "left join p.enderecos ep")
    List<PessoaComTodasRelacoesDTO> listarPessoaComRelacoes();
}
