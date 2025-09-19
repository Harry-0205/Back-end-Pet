package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {
    private UsuarioService usuSer;

    public UsuarioController( UsuarioService usuSer){
        this.usuSer=usuSer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoUsuarioGett> getUsu(@PathVariable Long id) {
        DtoUsuarioGett usu = usuSer.buscarId(id);
        return ResponseEntity.ok(usu);
    }
    @GetMapping("All/{id}")
    public ResponseEntity<DtoUsuario> getUsuAll(@PathVariable Long id) {
        DtoUsuario usuDto = usuSer.buscarIdAll(id);
        return ResponseEntity.ok(usuDto);
    }

    @PostMapping("/crear")
    public ResponseEntity<DtoUsuario> post(@Valid @RequestBody DtoUsuario dtoUsuario) {
        
        DtoUsuario post = usuSer.crear(dtoUsuario);
        return ResponseEntity.ok(post);
    }
    
    

}
