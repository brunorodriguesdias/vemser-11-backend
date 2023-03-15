package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    List<EnderecoEntity> findAllByTipo(TipoEndereco tipoEndereco);

    List<EnderecoEntity> findAllByCepOrderByLogradouro(String cep);

    List<EnderecoEntity> findAllByPessoa(PessoaEntity pessoaEntity);
}
