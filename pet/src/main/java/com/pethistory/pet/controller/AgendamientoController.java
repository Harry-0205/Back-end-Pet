package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.AgendamientoDto;
import com.pethistory.pet.service.AgendamientoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/agendamientos")
public class AgendamientoController {

    private final AgendamientoService agenServ;

    public AgendamientoController(AgendamientoService agenServ) {
        this.agenServ = agenServ;
    }


    @PostMapping("/Crear")
    public ResponseEntity<AgendamientoDto> crear(@Valid @RequestBody AgendamientoDto dto) {
        AgendamientoDto nuevo = agenServ.crear(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AgendamientoDto> obtenerPorId(@PathVariable Long id) {
        AgendamientoDto encontrado = agenServ.buscarPorId(id);
        return ResponseEntity.ok(encontrado);
    }


    @GetMapping("/Listar")
    public ResponseEntity<List<AgendamientoDto>> listarTodos() {
        List<AgendamientoDto> lista = agenServ.listarTodos();
        return ResponseEntity.ok(lista);
    }


    @PutMapping("/Actualizar{id}")
    public ResponseEntity<AgendamientoDto> actualizar(@PathVariable Long id, @Valid @RequestBody AgendamientoDto dto) {
        AgendamientoDto actualizado = agenServ.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

}
