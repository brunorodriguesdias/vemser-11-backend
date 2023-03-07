package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
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
public class EnderecoCreateDTO {
    private Integer idPessoa;

    @NotNull
    @Schema(description = "Tipo de endereço", example = "COMERCIAL")
    private TipoEndereco tipo;

    @NotBlank
    @Size(max=250)
    @Schema(description = "Nome do logradouro", example = "Assis Brasil")
    private String logradouro;

    @NotNull
    @Schema(description = "Número no logradouro", example = "669")
    private Integer numero;

    @Schema(description = "Complemento do endereço", example = "Apto 302")
    private String complemento;

    @NotBlank
    @Size(max=8)
    @Schema(description = "CEP do endereço", example = "94920270")
    private String cep;

    @NotBlank
    @Size(max=250)
    @Schema(description = "Cidade do endereço", example = "Porto Alegre")
    private String cidade;

    @NotNull
    @Schema(description = "Estado do endereço", example = "RS")
    private String estado;

    @NotNull
    @Schema(description = "País do endereço", example = "Brasil")
    private String pais;
}