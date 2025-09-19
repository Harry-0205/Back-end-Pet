package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.TipoDocDto;
import com.pethistory.pet.service.TipoDocService;

@RestController
@RequestMapping("/api/tipodoc")
public class TipoDocController {

    private TipoDocService tipoDocSer;
    public TipoDocController(TipoDocService tipoDocSer){
        this.tipoDocSer=tipoDocSer;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoDocDto> gettipodAll(@PathVariable Long id){
        TipoDocDto tipoDocDto= tipoDocSer.buscarIdAll(id);
        return ResponseEntity.ok(tipoDocDto);
    }
    @GetMapping
    public ResponseEntity<List<TipoDocDto>> getAll(){
        return ResponseEntity.ok(tipoDocSer.listarTodos());
    }
}
