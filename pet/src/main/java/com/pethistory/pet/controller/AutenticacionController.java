package com.pethistory.pet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.RespuestaInicioSesionDto;
import com.pethistory.pet.dtos.SolicitudInicioSesionDTO;
import com.pethistory.pet.service.AutenticacionService;

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionController {
    private final AutenticacionService autSer;

    public AutenticacionController(AutenticacionService autSer) {
        this.autSer = autSer;
    }

    @PostMapping("/login")
    public ResponseEntity<RespuestaInicioSesionDto> login(@RequestBody SolicitudInicioSesionDTO dto) {
        return ResponseEntity.ok(autSer.iniciarSesion(dto));
    }

}
