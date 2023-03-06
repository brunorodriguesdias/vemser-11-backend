package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {

    @NotBlank
    private String nome;

    @Past
    private LocalDate dataNascimento;

    @Size(min=11, max=11)
    private String cpf;
}
