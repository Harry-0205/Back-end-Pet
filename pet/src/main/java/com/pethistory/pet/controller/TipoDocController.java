package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.TipoDocDto;
import com.pethistory.pet.repositories.TipoDocRepo;

@RestController
@RequestMapping("/api/tipodoc")
public class TipoDocController {
    @Autowired
    private TipoDocRepo tipRepo;

    @GetMapping
    public List<TipoDocDto> getAllTipoDocs() {
        return tipRepo.findAll().stream().map(tipoDoc -> {
            TipoDocDto dto = new TipoDocDto();
            dto.setIdTipo(tipoDoc.getIdTipo());
            dto.setTipoDoc(tipoDoc.getTipoDoc());
            return dto;
        }).toList();
    }
    
}
