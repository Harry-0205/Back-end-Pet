package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.RolDto;
import com.pethistory.pet.repositories.RolRepositorye;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    private RolRepositorye rolRepo;

    @GetMapping
    public List<RolDto> getAllRoles() {
        return rolRepo.findAll().stream().map(rol -> {
            RolDto dto = new RolDto();
            dto.setIdRol(rol.getId());
            dto.setRol(rol.getNomRol());
            return dto;
        }).toList();
    }
}
