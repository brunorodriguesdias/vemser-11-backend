package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoFilme;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeCreateDTO {
    @NotBlank
    @Schema(description = "Descricao do filme", example = "Sinopse")
    private String descricao;

    @Schema(description = "Nota do filme", example = "7.54")
    private Double nota;

    @NotNull
    @Schema(description = "Categoria do filme", example = "TERROR")
    private TipoFilme tipo;
}
