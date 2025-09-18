package com.pethistory.pet;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.EspecieDto;
import com.pethistory.pet.service.EspecieService;

@RestController
@RequestMapping("/api/especie")
public class EspecieController {

    private EspecieService especieSer;
    public EspecieController(EspecieService especieSer){
        this.especieSer=especieSer;
    }
    @GetMapping("/{id}")
    public ResponseEntity<EspecieDto> getEspeAll(@PathVariable Long id){
        EspecieDto especieDto= especieSer.buscarIdAll(id);
        return ResponseEntity.ok(especieDto);
    }
    @GetMapping
    public ResponseEntity<List<EspecieDto>> getAll(){
        return ResponseEntity.ok(especieSer.listarTodos());
}
}
