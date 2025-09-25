package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.VacunasDto;
import com.pethistory.pet.repositories.VacunasRepo;



@RestController
@RequestMapping("/api/vacunas")
public class VacunasController {
    @Autowired
    private VacunasRepo vacRepo;
    @GetMapping
    public List<VacunasDto> getAllVacunas() {
        return vacRepo.findAll().stream().map(vacuna -> {
            VacunasDto dto = new VacunasDto();
            dto.setIdVacuna(vacuna.getId());
            dto.setVacuna(vacuna.getVacuna());
            dto.setDuracion(vacuna.getDuracion());
            dto.setDosis(vacuna.getDosis());
            dto.setCosto(vacuna.getCosto());
            dto.setIdEspecie(vacuna.getEspecie().getId());
            dto.setNomEspecie(vacuna.getEspecie().getNomEspecie());
            return dto;
        }).toList();
    }
}

