package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.CuentaDto;
import com.pethistory.pet.repositories.CuentaRepo;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
    @Autowired
    private CuentaRepo cuentaRepo;

    @GetMapping
    public List<CuentaDto> getAllCuentas() {
        return cuentaRepo.findAll().stream().map(cuenta -> {
            CuentaDto dto = new CuentaDto();
            dto.setCuenta(cuenta.getCorreo());
            return dto;
        }).toList();
    }
    @GetMapping("/{usuario}")
    public CuentaDto getCuentaByUsuario(@PathVariable String usuario) {
        return cuentaRepo.findById(usuario).map(cuenta -> {
            CuentaDto dto = new CuentaDto();
            dto.setCuenta(cuenta.getCorreo());
            return dto;
        }).orElse(null);
    }
}