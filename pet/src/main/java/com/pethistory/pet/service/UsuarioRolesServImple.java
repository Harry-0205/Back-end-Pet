package com.pethistory.pet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethistory.pet.dtos.DtoRespUsuAsigVet;
import com.pethistory.pet.dtos.DtoUsuarioAsignacionVet;
import com.pethistory.pet.dtos.UsuarioRolesDto;
import com.pethistory.pet.mapper.UsuarioRolesMapper;
import com.pethistory.pet.models.UsuarioRolId;
import com.pethistory.pet.models.UsuarioRoles;
import com.pethistory.pet.repositories.UsuarioRolesRepo;



@Service
public class UsuarioRolesServImple implements UsuarioRolesServ {
    private final UsuarioRolesRepo usuRolRepo;
    private final UsuarioRolesMapper usuRolMapper;

    public UsuarioRolesServImple (UsuarioRolesRepo usuRolRepo,UsuarioRolesMapper usuRolMapper){
        this.usuRolMapper=usuRolMapper;
        this.usuRolRepo=usuRolRepo;
    }
    @Override
    @Transactional
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
    @Transactional
    public List<UsuarioRolesDto> listarUsuarios (Long idDoc){
        return usuRolRepo.findByUsuario_id(idDoc).stream()
        .map(usuRolMapper::toUsuarioRolesDto)
        .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<UsuarioRolesDto> listarRol (Long idRol){
        return usuRolRepo.findByRol_id(idRol).stream()
        .map(usuRolMapper::toUsuarioRolesDto)
        .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public DtoRespUsuAsigVet asignarVarios(List<UsuarioRolesDto> lista ){
        List<DtoUsuarioAsignacionVet> respuestas= new ArrayList<>();
        int asignados=0, duplicados=0, fallidos=0;
        for (UsuarioRolesDto usuRolDto : lista) {
            DtoUsuarioAsignacionVet respuesta= new DtoUsuarioAsignacionVet();
            respuesta.setDoc(usuRolDto.getIdDocumento());
            respuesta.setIdRol(usuRolDto.getIdRol());
            try {
                UsuarioRolId id = new UsuarioRolId(usuRolDto.getIdDocumento(),usuRolDto.getIdRol());
                if (usuRolRepo.existsById(id)) {
                    respuesta.setEstado("DUPLICADO");
                    respuesta.setMensaje("El usuario con ese rol ya existe");
                    duplicados++;
                } else {
                    UsuarioRoles usuRol = usuRolMapper.toUsuarioRoles(usuRolDto);
                    usuRolRepo.save(usuRol);
                    respuesta.setEstado("ASIGNADO");
                    respuesta.setMensaje("Asignación exitosa");
                    asignados++;
                }
            } catch (Exception e) {
                respuesta.setEstado("FALLIDO");
                respuesta.setMensaje("Error al asignar el rol: " + e.getMessage());
                fallidos++;
            }
            respuestas.add(respuesta);
        }
        DtoRespUsuAsigVet resultado= new DtoRespUsuAsigVet();
        resultado.setTotalSolicitudes(lista.size());
        resultado.setTotalAsignaciones(asignados);
        resultado.setTotalDuplicadas(duplicados);
        resultado.setTotalFallidas(fallidos);
        resultado.setDetalles(respuestas);
        return resultado;
    }
}
