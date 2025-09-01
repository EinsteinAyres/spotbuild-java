package com.qu4rx.spotbuild.configuration;

// Importa as anotações e classes necessárias do Spring Security e Spring Framework.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Classe de configuração de segurança da aplicação.
 * - @Configuration: indica que esta classe contém beans de configuração do Spring.
 * - @EnableWebSecurity: ativa as configurações de segurança web do Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Define o filtro de segurança principal da aplicação.
     * - @Bean: Torna este método um bean gerenciado pelo Spring.
     * - HttpSecurity: Permite configurar as regras de segurança HTTP.
     * O método:
     * - Desabilita CSRF (útil para APIs REST, mas cuidado em apps web).
     * - Permite acesso público às rotas de documentação Swagger.
     * - Exige autenticação para qualquer outra rota.
     * - Habilita autenticação HTTP Basic.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Desabilita proteção CSRF (Cross-Site Request Forgery)
                .csrf(AbstractHttpConfigurer::disable)
                // Define regras de autorização para as requisições HTTP
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso sem autenticação às rotas de documentação
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        // Qualquer outra requisição precisa estar autenticada
                        .anyRequest().authenticated()
                )
                // Habilita autenticação HTTP Basic (usuário/senha via popup do navegador)
                .httpBasic(httpBasic -> {})
                // Constrói e retorna o filtro de segurança configurado
                .build();
    }

    /**
     * Define o serviço de autenticação de usuários.
     *
     * - @Bean: Torna este método um bean gerenciado pelo Spring.
     * - UserDetailsService: Interface usada pelo Spring Security para buscar detalhes do usuário.
     *
     * Neste exemplo, é usado um usuário em memória (útil para testes e protótipos).
     * - Username: admin
     * - Password: 1234 (o prefixo {noop} indica que não há codificação de senha)
     * - Role: USER
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // Cria um usuário com nome "admin", senha "1234" e papel "USER"
        UserDetails user = User.withUsername("admin")
                .password("{noop}1234") // {noop} = sem codificação de senha
                .roles("USER")
                .build();
        // Retorna um gerenciador de usuários em memória contendo esse usuário
        return new InMemoryUserDetailsManager(user);
    }
}