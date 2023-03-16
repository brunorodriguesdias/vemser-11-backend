package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "filme")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeEntity {
    @Id
    @Column(name = "id_filme")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILME_SEQ")
    @SequenceGenerator(name= "FILME_SEQ", sequenceName = "seq_filme", allocationSize = 1)
    private Integer idFilme;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota")
    private double nota;

    @Column(name = "tipo")
    private TipoFilme tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "filme", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PessoaXFilmeEntity> avaliacoes;
}
