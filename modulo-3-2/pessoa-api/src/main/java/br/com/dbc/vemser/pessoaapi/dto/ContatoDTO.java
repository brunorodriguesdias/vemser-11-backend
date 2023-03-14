package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "Id do contato")
    private Integer idContato;
}
