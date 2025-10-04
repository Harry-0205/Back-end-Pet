package com.pethistory.pet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pethistory.pet.repositories.UsuarioRolesRepo;
import com.pethistory.pet.service.JwtService;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion {
    private final JwtService jwtService;
    private final UsuarioRolesRepo usuRolRepo;
    public SeguridadConfiguracion(JwtService jwtService, UsuarioRolesRepo usuRolRepo) {
        this.jwtService = jwtService;
        this.usuRolRepo = usuRolRepo;
    }
    @Bean
    public SecurityFilterChain filtro (HttpSecurity http) throws Exception {
        return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/autenticacion/**").permitAll()
            .anyRequest().authenticated())
        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(new JwtFiltroAutenticacion(jwtService, usuRolRepo), UsernamePasswordAuthenticationFilter.class)
        .build();
    }
    @Bean
    public PasswordEncoder codificador(){
        return new BCryptPasswordEncoder();
    }
}
