package com.pethistory.pet.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.RespuestaInicioSesionDto;
import com.pethistory.pet.dtos.SolicitudInicioSesionDTO;
import com.pethistory.pet.exception.CredencialesInvalidasException;
import com.pethistory.pet.mapper.AutenticacionMapper;
import com.pethistory.pet.models.UsuarioRoles;
import com.pethistory.pet.repositories.UsuarioRolesRepo;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {
    private final UsuarioRolesRepo usuRolRepo;
    private final JwtService jwtSer;
    private final PasswordEncoder codificador;
    private final AutenticacionMapper mapper;
    public AutenticacionServiceImpl(UsuarioRolesRepo usuRolRepo, JwtService jwtSer, PasswordEncoder codificador,
            AutenticacionMapper mapper) {
        this.usuRolRepo = usuRolRepo;
        this.jwtSer = jwtSer;
        this.codificador = codificador;
        this.mapper = mapper;
    }

    @Override
    public RespuestaInicioSesionDto iniciarSesion(SolicitudInicioSesionDTO login) {
        UsuarioRoles usuarioRoles = usuRolRepo.findByUser(login.getUser())
                .orElseThrow(() -> new CredencialesInvalidasException("Usuario no encontrado"));
        if (!codificador.matches(login.getPassword(), usuarioRoles.getUsuario().getCuenta().getContra())) {
            throw new CredencialesInvalidasException("Contraseña incorrecta");
        }
        String token = jwtSer.generateToken(usuarioRoles);
        return mapper.aRespuestaInicioSesionDto(usuarioRoles, token);
    }

}
