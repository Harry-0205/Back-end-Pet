package com.pethistory.pet.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.pethistory.pet.models.UsuarioRoles;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private final String secret = "mi_clave_secreta";
    private final long expiration = 3600000;

    public String generateToken(UsuarioRoles user) {
        return Jwts.builder()
                .setSubject(user.getUsuario().getCuenta().getCorreo())
                .claim("rol", user.getRol().getNomRol())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
    public String obtenerUser(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean expiradoTk(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public boolean validarToken(String token, UsuarioRoles user) {
       return obtenerUser(token).equals(user.getUsuario().getCuenta().getCorreo()) && !expiradoTk(token);
    }
}
