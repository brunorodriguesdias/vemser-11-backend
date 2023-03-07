package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Nome da pessoa", example = "Alasca")
    private String nome;

    @Past
    @Schema(description = "Data de nascimento", example = "07/07/1993")
    private LocalDate dataNascimento;

    @Size(min=11, max=11)
    @Schema(description = "CPF da pessoa", example = "99988877766")
    private String cpf;

    @NotBlank
    @Schema(description = "Email da pessoa", example = "bruno@gmail.com")
    private String email;
}
