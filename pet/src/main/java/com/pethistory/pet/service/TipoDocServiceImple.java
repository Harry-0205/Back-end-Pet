package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.TipoDocDto;
import com.pethistory.pet.mapper.TipoDocMapper;
import com.pethistory.pet.repositories.TipoDocRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoDocServiceImple implements TipoDocService {

    private final TipoDocRepo tipoDocRepo;
    private final TipoDocMapper tipoDocMap;

    public TipoDocServiceImple(TipoDocRepo tipoDocRepo, TipoDocMapper tipoDocMap) {
        this.tipoDocRepo = tipoDocRepo;
        this.tipoDocMap = tipoDocMap;
    }
    @Override
    public TipoDocDto buscarIdAll(Long id){
        return tipoDocRepo.findById(id).map(tipoDocMap::toTipoDocDto).orElseThrow(()-> new EntityNotFoundException("Tipo de documento no encontrado") );
    }
    @Override
    public List<TipoDocDto> listarTodos(){
        return tipoDocRepo.findAll().stream().map(tipoDocMap::toTipoDocDto).collect(Collectors.toList());
    }
}