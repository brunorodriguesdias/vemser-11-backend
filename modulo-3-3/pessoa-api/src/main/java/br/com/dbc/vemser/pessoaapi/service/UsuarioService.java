package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
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

    public Optional<UsuarioEntity> findByLoginAndSenha (String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public UsuarioEntity verificaUsuario (LoginDTO loginDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> usuarioEntity = findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
        if(usuarioEntity.isEmpty()) {
            throw new RegraDeNegocioException("Usuário não encontrado!");
        }
        UsuarioEntity usuarioEncontrado = usuarioEntity.get();
        return usuarioEncontrado;
    }
}
