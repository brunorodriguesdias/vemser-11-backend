package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface DadosPessoaisDoc {

    @Operation(summary = "Listar Dados Pessoais", description = "Lista todos os dados pessoais")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de dados pessoais"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> getAll();
    @Operation(summary = "Listar dados pessoais por cpf", description = "Lista dados do cpf especificado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a dados do cpf especificado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> getCpf(@PathVariable String cpf) throws Exception;
    @Operation(summary = "Cadastrar dados", description = "Cadastra novos dados na lista")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os dados cadastrados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception;
    @Operation(summary = "Editar dados", description = "Edita dados do cpf especificado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os dados modificados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable String cpf,
                                                @Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception;
    @Operation(summary = "Deletar dados", description = "Deleta os dados do cpf especificado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna se a operação foi concluida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) throws Exception;
}
