package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
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
    private TipoEndereco tipo;

    @NotBlank
    @Size(max=250)
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @NotBlank
    @Size(max=8)
    private String cep;

    @NotBlank
    @Size(max=250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;
}