package com.pethistory.pet.config;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pethistory.pet.models.UsuarioRoles;
import com.pethistory.pet.repositories.UsuarioRolesRepo;
import com.pethistory.pet.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFiltroAutenticacion extends OncePerRequestFilter{
    private final JwtService jwtService;
    private final UsuarioRolesRepo usuRolRepo;
    public JwtFiltroAutenticacion(JwtService jwtService, UsuarioRolesRepo usuRolRepo) {
        this.jwtService = jwtService;
        this.usuRolRepo = usuRolRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        if (path.startsWith("/api/autenticacion")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
    }
    
        String token = authHeader.substring(7);
        String user = jwtService.obtenerUser(token);

        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UsuarioRoles usuarioRoles = usuRolRepo.findByUser(user).orElse(null);
            if (usuarioRoles != null && jwtService.validarToken(token, usuarioRoles)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuarioRoles, null, List.of(new SimpleGrantedAuthority(usuarioRoles.getRol().getNomRol())));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
