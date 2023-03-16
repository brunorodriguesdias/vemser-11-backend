package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    List<EnderecoEntity> findAllByTipo(TipoEndereco tipoEndereco);

    List<EnderecoEntity> findAllByCepOrderByLogradouro(String cep);

    List<EnderecoEntity> findAllByPessoa(PessoaEntity pessoaEntity);

    @Query("select e" +
            " from ENDERECO_PESSOA e" +
            " where e.pais = ?1")
    List<EnderecoEntity> findEnderecoByPais(String pais);

//    @Query("select ep " +
//            "from ENDERECO_PESSOA ep " +
//            "join ep.PESSOA_X_PESSOA_ENDERECO pxpe " +
//            "on (ep.id_pessoa = pxpe.id_pessoa) " +
//            "where ep.id_pessoa = ?1")
//    List<EnderecoEntity> findEnderecoByIdPessoa(Integer idPessoa);
}
