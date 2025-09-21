package com.pethistory.pet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.VeterinariasDto;
import com.pethistory.pet.service.VeterinariasService;

@RestController
@RequestMapping("/api/veterinarias")
public class VeterinariasController {
    private VeterinariasService vetserv;
    public VeterinariasController(VeterinariasService vetserv){
        this.vetserv=vetserv;
    }
    @GetMapping("/{id}")
    public ResponseEntity<VeterinariasDto>getvetid(@PathVariable Long id) {
        VeterinariasDto vetdto=vetserv.niit(id);
        return ResponseEntity.ok(vetdto);
    }
}
