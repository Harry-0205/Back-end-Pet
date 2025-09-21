package com.pethistory.pet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.ColorDto;
import com.pethistory.pet.service.ColorService;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    private ColorService colorSer;
    public ColorController(ColorService colorSer){
        this.colorSer=colorSer;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColorDto> getColAll(@PathVariable Long id){
        ColorDto colorDto= colorSer.buscarIdAll(id);
        return ResponseEntity.ok(colorDto);
    }
    @GetMapping
    public ResponseEntity<List<ColorDto>> getAll(){
        return ResponseEntity.ok(colorSer.listarTodos());
    }
}
