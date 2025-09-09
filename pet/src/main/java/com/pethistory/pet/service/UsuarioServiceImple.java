package com.pethistory.pet.service;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.mapper.UsuarioMapper;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.UsuarioRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImple implements UsuarioService {
    
    private final UsuarioRepo usuRepo;
    private final UsuarioMapper usuMap;

    public UsuarioServiceImple(UsuarioRepo usuRepo, UsuarioMapper usuMap){
        this.usuRepo= usuRepo;
        this.usuMap= usuMap;
    }

    @Override
    public DtoUsuario crear(DtoUsuario dtoUsuario){
        Usuario usuario = usuMap.toUsuario(dtoUsuario);
        Usuario guardado = usuRepo.save(usuario);
        return usuMap.toDtoUsuario(guardado);
    }
    @Override
    public DtoUsuario buscarId(Long id){
        return usuRepo.findById(id).map(usuMap::toDtoUsuario).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    }
}
