package com.pethistory.pet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.VeterinariasDto;
import com.pethistory.pet.service.VeterinariasService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    @GetMapping
    public ResponseEntity <List<VeterinariasDto>>getveterinarias(@PathVariable Long id){
        List<VeterinariasDto> lista=vetserv.listar();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crearVet")
    public ResponseEntity<?> post(@RequestBody VeterinariasDto dtoVet) {
        try{
            VeterinariasDto creado = vetserv.crear(dtoVet);
            return ResponseEntity.status(201).body(Map.of("mensaje", "La veterinaria fue exitosamente creada","data",creado));
        }catch(IllegalStateException ex){
            return ResponseEntity.status(409).body(Map.of("#1 Error al crear la veterinaria: " , ex.getMessage()));
        }
        catch(Exception ex){
            return ResponseEntity.status(500).body(Map.of("#2 Error al crear la veterinaria: " , ex.getMessage()));
        }
    }
    
    
}
