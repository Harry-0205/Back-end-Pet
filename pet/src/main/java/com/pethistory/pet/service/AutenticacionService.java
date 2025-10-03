package com.pethistory.pet.service;

import com.pethistory.pet.dtos.RespuestaInicioSesionDto;
import com.pethistory.pet.dtos.SolicitudInicioSesionDTO;

public interface AutenticacionService {
    RespuestaInicioSesionDto iniciarSesion(SolicitudInicioSesionDTO login);
}
