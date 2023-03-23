package br.com.dbc.vemser.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginCreateDTO {
    @NotNull
    private String login;
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
}
