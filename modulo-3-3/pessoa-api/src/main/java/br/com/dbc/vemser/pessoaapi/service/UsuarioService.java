package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticaticationManager;
    private final ObjectMapper objectMapper;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,@Lazy AuthenticationManager authenticaticationManager,
                          ObjectMapper objectMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.authenticaticationManager = authenticaticationManager;
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginDTO create(LoginCreateDTO loginCreateDTO) {
        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginCreateDTO, UsuarioEntity.class);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode(loginCreateDTO.getSenha());
        usuarioEntity.setSenha(senha);

        usuarioRepository.save(usuarioEntity);

        LoginDTO loginDTO = objectMapper.convertValue(usuarioEntity, LoginDTO.class);
        return loginDTO;
    }

    public Optional<UsuarioEntity> findByLoginAndSenha (String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByUsuario(Integer idUsuario) {
        return usuarioRepository.findByIdUsuario(idUsuario);
    }

    public Optional<UsuarioEntity> findByLogin (String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioEntity autenticar(LoginDTO loginDTO) throws RegraDeNegocioException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha());

        Authentication authentication;
        try {
            authentication =
                    authenticaticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException ex) {
            throw new RegraDeNegocioException("Usuario não encontrado");
        }

        Object principal = authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) principal;

        return usuarioEntity;
    }
}
