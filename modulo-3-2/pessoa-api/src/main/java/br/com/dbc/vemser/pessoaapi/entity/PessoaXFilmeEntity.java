package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity(name = "PESSOA_X_FILME")
public class PessoaXFilmeEntity {

    @EmbeddedId
    private PessoaPK pessoaPK;

    @Column(name = "dt_assistido")
    private LocalDate dtassistido;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota_pessoa")
    private double nota;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", insertable = false, updatable = false)
    private PessoaEntity pessoa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_filme", referencedColumnName = "id_filme", insertable = false, updatable = false)
    private FilmeEntity filme;
}
