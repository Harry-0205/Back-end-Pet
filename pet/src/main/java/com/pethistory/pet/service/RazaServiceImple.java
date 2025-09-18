package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.mapper.RazaMapper;
import com.pethistory.pet.models.Raza;
import com.pethistory.pet.repositories.RazaRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RazaServiceImple implements RazaService{

    private final RazaRepo razaRepo;
    private final RazaMapper razaMap;

    public RazaServiceImple(RazaRepo razaRepo, RazaMapper razaMap){
        this.razaRepo = razaRepo;
        this.razaMap = razaMap;
    }
    @Override
    public RazaDto crear(RazaDto razaDto){
        Raza raza = razaMap.toRaza(razaDto);
        Raza guardado = razaRepo.save(raza);
        return razaMap.toRazaDto(guardado);
    }
    @Override
        public RazaDto buscarIdAll(Long id){
            return razaRepo.findById(id).map(razaMap::toRazaDto).orElseThrow(()-> new EntityNotFoundException("Raza no encontrada"));
    }
    @Override
        public List<RazaDto> listarTodos(){
            return razaRepo.findAll().stream().map(razaMap::toRazaDto).collect(Collectors.toList());
        }
}
