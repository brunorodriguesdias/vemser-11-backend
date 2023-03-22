package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
//    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha (String login, String senha) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByLoginAndSenha(login, senha)
                .orElseThrow(() -> new RegraDeNegocioException("Usuario não encontrado!"));
        return Optional.of(usuarioEntity);
    }
}
