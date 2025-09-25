package com.pethistory.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.dtos.DtoUsuarioUpdate;
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
    @Transactional
    public DtoUsuario crear(DtoUsuario dtoUsuario){
        Usuario usuario = usuMap.toUsuario(dtoUsuario);
        Usuario guardado = usuRepo.save(usuario);
        return usuMap.toDtoUsuario(guardado);
    }
    @Override
    @Transactional
    public DtoUsuario buscarIdAll(Long id){
        return usuRepo.findById(id).map(usuMap::toDtoUsuario).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    }
    @Override
    public DtoUsuarioGett buscarId(Long id){
        return usuRepo.findById(id).map(usuMap::toDtoUsuarioGett).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    }
    @Override
    @Transactional
    public List<DtoUsuarioGett> listar(){
        return usuRepo.findAll().stream().map(usuMap::toDtoUsuarioGett).toList();
    }
    @Override
    @Transactional
    public DtoUsuario update(DtoUsuarioUpdate dtoUsuarioUpdate){
        Usuario usuario = usuRepo.findById(dtoUsuarioUpdate.getNumDoc()).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
        usuario.setNom(dtoUsuarioUpdate.getNombre());
        usuario.setApe1(dtoUsuarioUpdate.getApeUno());
        usuario.setApe2(dtoUsuarioUpdate.getApeDos());
        usuario.setTel(dtoUsuarioUpdate.getTelefono());
        usuario.setDir(dtoUsuarioUpdate.getDireccion());
        Usuario actualizado = usuRepo.save(usuario);
        return usuMap.toDtoUsuario(actualizado);
    }
}
