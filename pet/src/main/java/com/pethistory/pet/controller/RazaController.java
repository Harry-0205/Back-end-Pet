package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.repositories.RazaRepo;

@RestController
@RequestMapping("/api/raza")
public class RazaController {

    @Autowired
    private RazaRepo razaRepo;
    @GetMapping
    public List<RazaDto> getAllRazas() {
        return razaRepo.findAll().stream().map(raza -> {
            RazaDto dto = new RazaDto();
            dto.setIdRaza(raza.getId());
            dto.setNomEspecie(raza.getRaza());
            dto.setIdEspecie(raza.getEspecie().getId());
            dto.setNomEspecie(raza.getEspecie().getNomEspecie());
            return dto;
        }).toList();
    }

}
