package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.VacunasDto;
import com.pethistory.pet.service.VacunasService;



@RestController
@RequestMapping("/api/vacunas")
public class VacunasController {

    private VacunasService vacuSer;

    public VacunasController (VacunasService vacuSer){
        this.vacuSer=vacuSer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacunasDto> getVacuAll (@PathVariable Long id){
        VacunasDto vacunasDto= vacuSer.buscarIdAll(id);
        return ResponseEntity.ok(vacunasDto);
    }
    
    @GetMapping
    public ResponseEntity<List<VacunasDto>> getAll(){
        return ResponseEntity.ok(vacuSer.listarTodos());
    }
}
    
    

    
    


