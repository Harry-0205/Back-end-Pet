package com.pethistory.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethistory.pet.dtos.HistoriaClinicaDto;
import com.pethistory.pet.service.HistoriaclinicaService;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/historiaClinica")
public class Historiaclinicacontroller {

    private HistoriaclinicaService hisserv;

    public Historiaclinicacontroller(HistoriaclinicaService hisserv){
        this.hisserv=hisserv;
    }
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinicaDto>gethisid(@PathVariable Long id) {
        HistoriaClinicaDto hisdto=hisserv.buscarId(id);
        return ResponseEntity.ok(hisdto);
    }

    @PostMapping("/crearHis")
    public  ResponseEntity<?> post(@RequestBody HistoriaClinicaDto dtoHis) {
        try{
            HistoriaClinicaDto creado = hisserv.crear(dtoHis);
            return ResponseEntity.status(201).body(Map.of("mensaje", "La historia clinica fue exitosamente creada","data",creado));
        }catch(IllegalStateException ex){
            return ResponseEntity.status(409).body(Map.of("#1 Error al crear la historia clinica: " , ex.getMessage()));
        }
        catch(Exception ex){
            return ResponseEntity.status(500).body(Map.of("#2 Error al crear la historia clinica: " , ex.getMessage()));
        }

    }
@GetMapping("path")
public ResponseEntity<List<HistoriaClinicaDto>>gettodaslasHis(){
    List<HistoriaClinicaDto> lista=hisserv.todaslasHis();
    return ResponseEntity.ok(lista);
    
}

}
    
    

