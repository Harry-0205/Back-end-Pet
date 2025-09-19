package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.dtos.DtoMascotaAll;
import com.pethistory.pet.dtos.MascotaUpdateDto;
import com.pethistory.pet.service.MascotaService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




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

    @PutMapping("actualizar/{id}")
    public ResponseEntity <DtoMascota> actualizar(@PathVariable Long id, @Valid @RequestBody MascotaUpdateDto dto) {
        dto.setIdMasc(id);
        DtoMascota actualizado = mascSer.actualizarMascota(dto);
        return ResponseEntity.ok(actualizado);
    }

}
