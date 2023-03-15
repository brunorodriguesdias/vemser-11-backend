package br.com.dbc.vemser.pessoaapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class PessoaPK implements Serializable {
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "id_filme")
    private Integer idFilme;
}
