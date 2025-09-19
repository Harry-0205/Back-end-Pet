package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.HistoriaClinicaDto;
import com.pethistory.pet.service.HistoriaclinicaService;
import com.pethistory.pet.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/historiaClinica")
public class Historiaclinicacontroller {

    private HistoriaclinicaService hisserv;

    public Historiaclinicacontroller(HistoriaclinicaService hisserv){
        this.hisserv=hisserv;
    }
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinicaDto>gethisid(@PathVariable Long id) {
        HistoriaClinicaDto hisdto=hisserv.buscarId(id);
        return ResponseEntity.ok(hisdto);
    }
    
}
