package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.dtos.DtoMascotaAll;
import com.pethistory.pet.dtos.MascotaCreateDto;
import com.pethistory.pet.dtos.MascotaUpdateDto;
import com.pethistory.pet.service.MascotaService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping("/api/Mascota")
public class MascotaController {
    private MascotaService mascSer;
    
    public MascotaController(MascotaService mascSer){
        this.mascSer=mascSer;
    }


    @PostMapping("/crear")
    public ResponseEntity<?> crearMasc(@Valid @RequestBody MascotaCreateDto dto) {
        try{
        DtoMascota  creado = mascSer.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(Map.of("mensaje", "MAscota creado exitosamente", "data", creado));
    }catch(IllegalStateException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(Map.of("error", ex.getMessage()));
    }catch(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(Map.of("Error","Error al crear la mascota","Detalle", ex.getMessage()));
    }
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

    @GetMapping
    public ResponseEntity <List<DtoMascota>> listartodos() {
        List<DtoMascota> mascotas = mascSer.listartodos();
        return ResponseEntity.ok(mascotas);
    }
    

}
