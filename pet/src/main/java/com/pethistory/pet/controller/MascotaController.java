package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.dtos.DtoMascotaAll;
import com.pethistory.pet.service.MascotaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/Mascota")
public class MascotaController {
    private MascotaService mascSer;
    
    public MascotaController(MascotaService mascSer){
        this.mascSer=mascSer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoMascota> getMasc (@PathVariable Long id) {
        DtoMascota mascDto = mascSer.buscarIdAll(id);
        return ResponseEntity.ok(mascDto);
    }

    @GetMapping("/All/{id}")
    public ResponseEntity <DtoMascotaAll> getMascAll(@PathVariable Long id) {
        DtoMascotaAll mascDtoAll = mascSer.buscarId(id);
        return ResponseEntity.ok(mascDtoAll);
    }
    
    
    

}
