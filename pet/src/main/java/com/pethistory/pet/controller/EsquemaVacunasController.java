package com.pethistory.pet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoEsquemaVacunas;
import com.pethistory.pet.dtos.EsquemaVacunasCreateDto;
import com.pethistory.pet.service.EsquemaVacunasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/EsquemaVacunas")
public class EsquemaVacunasController {

    private final EsquemaVacunasService service;

    public EsquemaVacunasController(EsquemaVacunasService service){
        this.service = service;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody EsquemaVacunasCreateDto dto){
        try{
            DtoEsquemaVacunas creado = service.crear(dto);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", "Esquema de vacunas creado exitosamente", "data", creado));
        }catch(IllegalStateException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", ex.getMessage()));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("Error", "Error al crear el esquema de vacunas", "Detalle", ex.getMessage()));
        }
    }

    @PostMapping("/crearVarios")
    public ResponseEntity<Map<String, Object>> crearSista(@RequestBody List<EsquemaVacunasCreateDto> lista){
        Map<String, Object> respuesta = service.crearVarios(lista);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoEsquemaVacunas> obtener(@PathVariable Long id){
        DtoEsquemaVacunas dto = service.obtener(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<List<DtoEsquemaVacunas>> listarPorMascota(@PathVariable Long idMascota){
        List<DtoEsquemaVacunas> lista = service.listarPorMascota(idMascota);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/vacuna/{idVacuna}")
    public ResponseEntity<List<DtoEsquemaVacunas>> listarPorVacuna(@PathVariable Long idVacuna){
        List<DtoEsquemaVacunas> lista = service.listarPorVacuna(idVacuna);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DtoEsquemaVacunas> actualizar(@Valid @RequestBody DtoEsquemaVacunas dto){
        DtoEsquemaVacunas actualizado = service.actualizar(dto);
        return ResponseEntity.ok(actualizado);
    }

    
    }
