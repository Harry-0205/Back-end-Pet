package com.pethistory.pet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pethistory.pet.dtos.UsuarioRolesDto;
import com.pethistory.pet.mapper.UsuarioRolesMapper;
import com.pethistory.pet.models.UsuarioRolId;
import com.pethistory.pet.models.UsuarioRoles;
import com.pethistory.pet.repositories.UsuarioRolesRepo;

public class UsuarioRolesServImple implements UsuarioRolesServ {
    private final UsuarioRolesRepo usuRolRepo;
    private final UsuarioRolesMapper usuRolMapper;

    public UsuarioRolesServImple (UsuarioRolesRepo usuRolRepo,UsuarioRolesMapper usuRolMapper){
        this.usuRolMapper=usuRolMapper;
        this.usuRolRepo=usuRolRepo;
    }
    @Override
    public UsuarioRolesDto crear (UsuarioRolesDto usuarioRolesDto){
        UsuarioRoles usuRol = usuRolMapper.toUsuarioRoles(usuarioRolesDto);
        UsuarioRolId id = new UsuarioRolId(usuarioRolesDto.getIdDocumento(),usuarioRolesDto.getIdRol());
        if (usuRolRepo.existsById(id)) {
            throw new IllegalStateException("El usuario con ese rol ya existe");
        }
        UsuarioRoles saveUsuRol = usuRolRepo.save(usuRol);
        return usuRolMapper.toUsuarioRolesDto(saveUsuRol);
    }
    @Override
    public List<UsuarioRolesDto> listarUsuarios (Long idDoc){
        return usuRolRepo.findByUsuario_id(idDoc).stream()
        .map(usuRolMapper::toUsuarioRolesDto)
        .collect(Collectors.toList());
    }
    @Override
    public List<UsuarioRolesDto> listarRol (Long idRol){
        return usuRolRepo.findByRol_id(idRol).stream()
        .map(usuRolMapper::toUsuarioRolesDto)
        .collect(Collectors.toList());
    }
    @Override
    public List<UsuarioRolesDto> asignarVarios(List<UsuarioRolesDto> lista ){

        List<UsuarioRolesDto> lis = new ArrayList<>();

        for(UsuarioRolesDto dto : lista){

            try{
                UsuarioRolesDto asignado = crear(dto);
                lis.add(asignado);
            }
            catch (Exception e){
                System.out.println("Error al asignar rol");
            }
            
        }
        return lis;
    }
}
