package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoCreateDTO {
    @Schema(description = "Id da pessoa", example = "1")
    private Integer idPessoa;

    @NotNull
    @Schema(description = "Tipo do contato", example = "COMERCIAL")
    private TipoContato tipo;

    @NotNull
    @Size(max=13)
    @Schema(description = "Telefone", example = "51994414634")
    private String numero;

    @NotBlank
    @Schema(description = "Descrição do contato", example = "Celular")
    private String descricao;
}
