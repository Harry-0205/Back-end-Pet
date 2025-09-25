package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.Dto_procedimiento_historiaclinica;
import com.pethistory.pet.service.ProcedimientoHisCliService;

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
public class ProHisCliController {
    private final ProcedimientoHisCliService prohiscliserv;
    public ProHisCliController(ProcedimientoHisCliService prohiscliserv){
        this.prohiscliserv=prohiscliserv;
    }
    @PostMapping("/cearpro")
    public ResponseEntity<Dto_procedimiento_historiaclinica>asignar(@Valid@RequestBody Dto_procedimiento_historiaclinica dto) {
        Dto_procedimiento_historiaclinica epa=prohiscliserv.crear(dto);
        return ResponseEntity.ok(epa);
    }
    @GetMapping("/prohiscli{id}")
    public ResponseEntity<List<Dto_procedimiento_historiaclinica>> buscaprohiscli(@PathVariable Long id) {
        return ResponseEntity.ok(prohiscliserv.listarPorProcedimiento(id));
    }
}
