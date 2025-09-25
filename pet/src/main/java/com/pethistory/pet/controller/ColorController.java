package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.ColorDto;
import com.pethistory.pet.repositories.ColorRepositorio;

@RestController
@RequestMapping("/api/color")
public class ColorController {
    @Autowired
    private ColorRepositorio colRep;

    @GetMapping
    public List<ColorDto> getAllColors() {
        return colRep.findAll().stream().map(color -> {
            ColorDto dto = new ColorDto();
            dto.setIdColor(color.getId());
            dto.setNomColor(color.getNomColor());
            return dto;
        }).toList();
    }
}
