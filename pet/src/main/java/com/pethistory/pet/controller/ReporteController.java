package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.service.ReporteService;

import jakarta.validation.Valid;

import java.security.PublicKey;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/prohiscli")
public class ReporteController {
    private final ReporteService prohiscliserv;
    public ReporteController(ReporteService prohiscliserv){
        this.prohiscliserv=prohiscliserv;
    }
    @PostMapping("/cearpro")
    public ResponseEntity<ReporteDto>asignar(@Valid@RequestBody ReporteDto dto) {
        ReporteDto epa=prohiscliserv.crear(dto);
        return ResponseEntity.ok(epa);
    }
    @GetMapping("/prohiscli{id}")
    public ResponseEntity<List<ReporteDto>> buscaprohiscli(@PathVariable Long id) {
        return ResponseEntity.ok(prohiscliserv.listarPorProcedimiento(id));
    }
}
