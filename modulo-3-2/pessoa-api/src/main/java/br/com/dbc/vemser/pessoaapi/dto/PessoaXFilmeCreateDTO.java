package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaPK;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaXFilmeCreateDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Integer idFilme;

    @NotNull
    private LocalDate dtassistido;

    @NotBlank
    private String descricao;

    @NotNull
    private double nota;

}
