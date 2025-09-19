package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.service.RazaService;

@RestController
@RequestMapping("/api/raza")
public class RazaController {

    private RazaService razaSer;

    public RazaController (RazaService razaSer){
        this.razaSer=razaSer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazaDto> getRazAll(@PathVariable Long id){
        RazaDto razaDto= razaSer.buscarIdAll(id);
        return ResponseEntity.ok(razaDto);
    }

    @GetMapping
    public ResponseEntity<List<RazaDto>> getAll(){
        return ResponseEntity.ok(razaSer.listarTodos());
    }
}
