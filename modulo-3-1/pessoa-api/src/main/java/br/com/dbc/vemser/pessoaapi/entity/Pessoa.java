package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
}
