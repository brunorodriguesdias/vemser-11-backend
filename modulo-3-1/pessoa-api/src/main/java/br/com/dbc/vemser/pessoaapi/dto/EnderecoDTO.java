package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO{
    @Schema(description = "Id do endereço")
    private Integer idEndereco;
}
