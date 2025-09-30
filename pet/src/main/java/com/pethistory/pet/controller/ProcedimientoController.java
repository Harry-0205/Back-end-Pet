package com.pethistory.pet.controller;

import com.pethistory.pet.dtos.ProcedimientoDto;
import com.pethistory.pet.service.ProcedimientoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedimientos")
public class ProcedimientoController {

    private final ProcedimientoService procedimientoService;

    public ProcedimientoController(ProcedimientoService procedimientoService) {
        this.procedimientoService = procedimientoService;
    }

    @PostMapping
    public ResponseEntity<ProcedimientoDto> crear(@Valid @RequestBody ProcedimientoDto dto) {
        ProcedimientoDto creado = procedimientoService.crear(dto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcedimientoDto> obtenerPorId(@PathVariable Long id) {
        ProcedimientoDto encontrado = procedimientoService.buscarPorId(id);
        return ResponseEntity.ok(encontrado);
    }

    @GetMapping
    public ResponseEntity<List<ProcedimientoDto>> listarTodos() {
        List<ProcedimientoDto> lista = procedimientoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<ProcedimientoDto> actualizar(@PathVariable Long id, @Valid @RequestBody ProcedimientoDto dto) {
        ProcedimientoDto actualizado = procedimientoService.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
