package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
public class PetEntity {
    @Id
    @Column(name = "id_pet")
    private Integer idPet;

    @Column(name = "id_pessoa", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo_pet")
    private TipoPet tipoPet;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private PessoaEntity pessoas;

}
