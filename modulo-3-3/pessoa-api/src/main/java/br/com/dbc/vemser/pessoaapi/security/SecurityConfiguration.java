package br.com.dbc.vemser.pessoaapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final TokenService tokenService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // FIXME desabilitar frameOptions
        // FIXME habilitar cors
        // FIXME desabilitar csrf
        // FIXME adicionar regras de requisição
        // FIXME adicionar filtro do token
        http.headers().frameOptions().disable()
                .and().cors()
                .and().csrf().disable()
                .authorizeHttpRequests((requisicao) ->
                        requisicao.antMatchers("/")
                        .permitAll()
                        .anyRequest()
                        .authenticated());
        http.addFilterBefore(new TokenAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // FIXME fazer o security ignorar o swagger
        return (web) -> web.ignoring().antMatchers("/swagger-ui/**",
                                                                "/v3/api-docs/**",
                                                                "/auth",
                                                                "/auth/create");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // FIXME adicionar cors (mapping, methods e headers)
                registry.addMapping("/**").allowedHeaders("*").allowedMethods("GET", "PUT", "DELETE", "POST");
            }
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticaonManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
