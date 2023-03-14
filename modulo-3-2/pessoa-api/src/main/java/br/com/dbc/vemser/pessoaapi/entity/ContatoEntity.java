package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

//@Data não usar o @Data
@Getter
@Setter
@Entity(name = "CONTATO")
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntity {

    @Id
    @Column(name = "id_contato")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    private Integer idContato;

    private Integer idPessoa;

    @Column(name = "tipo")
    private TipoContato tipoContato;

    @Column(name = "numero")
    private String numero;

    @Column(name = "descricao")
    private String descricao;
}
