//package br.com.dbc.vemser.pessoaapi.controller;
//
//import br.com.dbc.vemser.pessoaapi.entity.*;
//import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
//import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
//import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
//import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.constraints.NotBlank;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.OK;
//
//
//
//@Validated
//@RestController
//@RequestMapping("/consulta")
//@RequiredArgsConstructor
//public class ConsultasController {
//
//    private final PessoaRepository pessoaRepository;
//    private final ContatoRepository contatoRepository;
//    private final EnderecoRepository enderecoRepository;
//
//    @GetMapping("/pessoa/nome/") // GET localhost:8080/consulta/pessoa/nome/
//    public ResponseEntity<List<PessoaEntity>> findPessoByNome (@RequestParam("nome") @NotBlank String nome) {
//        return new ResponseEntity<>(pessoaRepository.findByNomeContainsIgnoreCase(nome), OK);
//    }
//
//    @GetMapping("/pessoa/cpf/{cpf}") // GET localhost:8080/consulta/pessoa/cpf/
//    public ResponseEntity<PessoaEntity> findPessoaByCpf (@RequestParam("cpf") @NotBlank String cpf) throws RegraDeNegocioException {
//        PessoaEntity pessoaEntity = pessoaRepository.findByCpf(cpf)
//                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
//        return new ResponseEntity<>(pessoaEntity, OK);
//    }
//
//    @GetMapping("/pessoa/nascimento")
//    public ResponseEntity<List<PessoaEntity>> findByDataNascimento (@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
//                                                                    @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
//        return new ResponseEntity<>(pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal), OK);
//    }
//
//    @GetMapping("/contato/tipo")
//    public ResponseEntity<List<ContatoEntity>> findContatoByTipo (@RequestParam("tipo") TipoContato tipoContato) {
//        return new ResponseEntity<>(contatoRepository.findAllByTipo(tipoContato), OK);
//    }
//
//    @GetMapping("/endereco/tipo")
//    public ResponseEntity<List<EnderecoEntity>> findEnderecoByTipo (@RequestParam("tipo") TipoEndereco tipoEndereco) {
//        return new ResponseEntity<>(enderecoRepository.findAllByTipo(tipoEndereco), OK);
//    }
//
//    @GetMapping("/endereco/cep")
//    public ResponseEntity<List<EnderecoEntity>> findEnderecoByCep (@RequestParam("cep") String cep) {
//        return new ResponseEntity<>(enderecoRepository.findAllByCepOrderByLogradouro(cep), OK);
//    }
//
//}