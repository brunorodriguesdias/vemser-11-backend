package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
