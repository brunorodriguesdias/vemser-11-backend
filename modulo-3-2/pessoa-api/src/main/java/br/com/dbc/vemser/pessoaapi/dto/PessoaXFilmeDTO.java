package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaPK;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Data
public class PessoaXFilmeDTO extends PessoaXFilmeCreateDTO{

    private PessoaPK pessoaPK;
}
