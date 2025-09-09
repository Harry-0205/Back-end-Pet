package com.pethistory.pet.service;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.mapper.UsuarioGettMapper;
import com.pethistory.pet.repositories.UsuarioRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioGettServiceImple implements UsuarioGettService{

    private final UsuarioRepo usuRepo;
    private final UsuarioGettMapper usuGettMap;

    public UsuarioGettServiceImple(UsuarioRepo usuRepo, UsuarioGettMapper usuGettMap){
        this.usuRepo= usuRepo;
        this.usuGettMap= usuGettMap;
    }

    @Override
    public DtoUsuarioGett buscarId(Long id){
        return usuRepo.findById(id).map(usuGettMap::toDtoUsuarioGett).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    }
}
