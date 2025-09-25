package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoRespUsuAsigVet;
import com.pethistory.pet.dtos.UsuarioRolesDto;
import com.pethistory.pet.service.UsuarioRolesServ;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/UsuarioRol")
public class UsuarioRolController {
    private final UsuarioRolesServ usuRolSer;
    public UsuarioRolController(UsuarioRolesServ usuRolSer){
        this.usuRolSer=usuRolSer;
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioRolesDto> asignar(@Valid@RequestBody UsuarioRolesDto dto){
        UsuarioRolesDto usu = usuRolSer.crear(dto);       
        return ResponseEntity.ok(usu);
    }
    @PostMapping("/crearVarios")
    public ResponseEntity<DtoRespUsuAsigVet> varios(@RequestBody List<UsuarioRolesDto> asignaciones){
        DtoRespUsuAsigVet usuList = usuRolSer.asignarVarios(asignaciones);
        return ResponseEntity.ok(usuList);
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<UsuarioRolesDto>> getUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuRolSer.listarUsuarios(id));
    }
    @GetMapping("/rol/{id}")
    public ResponseEntity<List<UsuarioRolesDto>> getRol(@PathVariable Long id) {
        return ResponseEntity.ok(usuRolSer.listarRol(id));
    }
}
