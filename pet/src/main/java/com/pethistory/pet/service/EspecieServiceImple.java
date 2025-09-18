package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.EspecieDto;
import com.pethistory.pet.mapper.EspecieMapper;
import com.pethistory.pet.models.Especie;
import com.pethistory.pet.repositories.EspecieRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EspecieServiceImple implements EspecieService {

    private final EspecieRepositorio especieRepo;
    private final EspecieMapper especieMap;

    public EspecieServiceImple(EspecieRepositorio especieRepo, EspecieMapper especieMap){
        this.especieRepo = especieRepo;
        this.especieMap = especieMap;
    }
    @Override
    public EspecieDto crear(EspecieDto especieDto){
        Especie especie = especieMap.toEspecie(especieDto);
        Especie guardado = especieRepo.save(especie);
        return especieMap.toEspecieDto(guardado);
    }
    @Override
        public EspecieDto buscarIdAll(Long id){
            return especieRepo.findById(id).map(especieMap::toEspecieDto).orElseThrow(()-> new EntityNotFoundException("Especie no encontrada"));
    }
    @Override
        public List<EspecieDto> listarTodos(){
            return especieRepo.findAll().stream().map(especieMap::toEspecieDto).collect(Collectors.toList());
        }
}
