package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaXFilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaXFilmeRepository extends JpaRepository<PessoaXFilmeEntity, Integer> {
}
