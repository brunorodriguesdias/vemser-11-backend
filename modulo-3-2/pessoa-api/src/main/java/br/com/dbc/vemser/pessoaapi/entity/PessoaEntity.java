package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
//@Data não usar o @Data
@Getter
@Setter
@Entity(name = "PESSOA")
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {
    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name= "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column
    private String email;
}
