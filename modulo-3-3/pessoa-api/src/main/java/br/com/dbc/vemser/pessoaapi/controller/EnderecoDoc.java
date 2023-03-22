package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface EnderecoDoc {
    @Operation(summary = "Listar endereços cadastrados", description = "Lista todos endereços cadastrados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // GET localhost:8080/endereco
    public List<EnderecoDTO> list () throws RegraDeNegocioException;

    @Operation(summary = "Buscar endereço por id", description = "Busca um endereço pelo seu id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o endereço solicitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}") // GET localhost:8080/endereco/{idEndereco}
    public ResponseEntity<EnderecoDTO> endereco (@PathVariable("idEndereco") Integer idEndereco) throws Exception;

    @Operation(summary = "Buscar endereços por id pessoa", description = "Busca endereços cadastrados naquele id de pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços cadastrados para aquela pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/endereco/{idPessoa}
    public ResponseEntity<List<EnderecoDTO>> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception;

    @Operation(summary = "Criar endereço", description = "Cria um novo endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o novo endereço criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/criar") // POST localhost:8080/endereco/{idPessoa}
    public EnderecoDTO create (@Valid @RequestBody EnderecoCreateDTO enderecoDTO) throws Exception;

    @Operation(summary = "Editar endereço", description = "Edita o endereço selecionado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o endereço editado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}") // POST localhost:8080/endereco/{idEndereco}
    public EnderecoDTO update (@PathVariable("idEndereco") Integer idEndereco,
                               @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception;

    @Operation(summary = "Deletar endereço", description = "Deleta o endereço selecionado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Confirma que a deleção foi realizada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer idEndereco) throws Exception;
}
