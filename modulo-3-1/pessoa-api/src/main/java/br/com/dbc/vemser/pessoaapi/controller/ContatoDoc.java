package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ContatoDoc {
    @Operation(summary = "Listar contatos", description = "Lista todos os contatos cadastrados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos cadastrados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // GET localhost:8080/contato
    public List<ContatoDTO> list ();

    @Operation(summary = "Buscar contato por id da pessoa", description = "Busca endereços cadastrados naquele id de pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "retorna contatos cadastrados naquele id de pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}") // GET localhost:8080/contato/{idPessoa}
    public ResponseEntity<List<ContatoDTO>> listaPorPessoa (@PathVariable("idPessoa") Integer idPessoa) throws Exception;

    @Operation(summary = "Criar contato", description = "Cria um novo contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") // POST localhost:8080/contato/{idPessoa}
    public ContatoDTO create(@PathVariable Integer idPessoa,
                             @Valid @RequestBody ContatoCreateDTO contatoDTO) throws Exception;

    @Operation(summary = "Edita um contato", description = "Edita o contato selecionado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato editado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}") // PUT localhost:8080/contato/{idContato}
    public ContatoDTO update(@PathVariable("idContato") Integer id,
                             @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception;

    @Operation(summary = "Deletar contato", description = "Deleta o contato selecionado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Confirma que a deleção foi realizada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception;
}
