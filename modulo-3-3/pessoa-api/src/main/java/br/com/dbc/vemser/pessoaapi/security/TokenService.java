package br.com.dbc.vemser.pessoaapi.security;


import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;
    private static final String BEARER = "Bearer ";

    public String gerarToken(LoginDTO loginDTO) throws RegraDeNegocioException {
        // usuario = login = user  | senha = 123
        Optional<UsuarioEntity> usuarioEntity = usuarioService.findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
        if(usuarioEntity.isEmpty()) {
            throw new RegraDeNegocioException("Usuário não encontrado!");
        }
        UsuarioEntity usuarioEncontrado = usuarioEntity.get();
        String tokenTexto = usuarioEncontrado.getLogin() + ";" + usuarioEncontrado.getSenha(); // user;123
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes()); // dXNlcjsxMjM=
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token) throws RegraDeNegocioException {
        if(token == null){
            return Optional.empty();
        }
        token = token.replace(BEARER, "");
        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes); // login;senha
        String[] split = decoded.split(";"); // [0] login [1] senha
        return usuarioService.findByLoginAndSenha(split[0], split[1]);
    }
}
