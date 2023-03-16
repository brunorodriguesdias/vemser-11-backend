package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaComTodasRelacoesDTO {
    private Integer idPessoa;

    private String nome;

    private String email;

    private String numero;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

    private String nomePet;

    private String descricao;

    private String descricaoPessoa;

    private LocalDate dtAssistido;

    private Double notaPessoa;

    private Double nota;
}
