package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.EspecieDto;
import com.pethistory.pet.repositories.EspecieRepositorio;

@RestController
@RequestMapping("/api/especie")
public class EspecieController {
    @Autowired
    private EspecieRepositorio espRepo;

    @GetMapping
    public List<EspecieDto> getAllEspecies() {
        return espRepo.findAll().stream().map(especie -> {
            EspecieDto dto = new EspecieDto();
            dto.setIdEspecie(especie.getId());
            dto.setNomEspecie(especie.getNomEspecie());
            return dto;
        }).toList();
    }
}
