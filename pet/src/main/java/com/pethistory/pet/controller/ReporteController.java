package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.dtos.RespAsignProDto;
import com.pethistory.pet.service.ReporteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api/report")
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
    @PostMapping("/crearvarios")
    public ResponseEntity<RespAsignProDto>varios(@RequestBody List<ReporteDto> asignaciones) {
        RespAsignProDto repList = prohiscliserv.asignar(asignaciones);
        return ResponseEntity.ok(repList);
    }
    
    @GetMapping("/prohiscli{id}")
    public ResponseEntity<List<ReporteDto>> buscarRep(@PathVariable Long id) {
        return ResponseEntity.ok(prohiscliserv.listarPorProcedimiento(id));
    }

    
}
