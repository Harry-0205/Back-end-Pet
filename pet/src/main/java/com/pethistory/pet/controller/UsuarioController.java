package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.dtos.DtoUsuarioUpdate;
import com.pethistory.pet.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {
    private UsuarioService usuSer;

    public UsuarioController( UsuarioService usuSer){
        this.usuSer=usuSer;
    }

    @GetMapping
    public ResponseEntity<List<DtoUsuarioGett>> getAll() {
        List<DtoUsuarioGett> lista = usuSer.listar();
        return ResponseEntity.ok(lista);
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
    public ResponseEntity<?> post(@Valid @RequestBody DtoUsuario dtoUsuario) {
        try{
            DtoUsuario creado = usuSer.crear(dtoUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "El usuario fue exitosamente creado","data",creado));
        }catch(IllegalStateException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("#1 Error al crear el usuario: " , ex.getMessage()));
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("#2 Error al crear el usuario: " , ex.getMessage()));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<DtoUsuario> put(@Valid @RequestBody DtoUsuarioUpdate dto){
        DtoUsuario actualizado = usuSer.update(dto);
        return ResponseEntity.ok(actualizado);
    }
    
    

}
