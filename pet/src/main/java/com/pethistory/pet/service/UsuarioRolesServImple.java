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
import com.pethistory.pet.models.Rol;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.models.UsuarioRolId;
import com.pethistory.pet.models.UsuarioRoles;
import com.pethistory.pet.models.Veterinarias;
import com.pethistory.pet.repositories.RolRepositorye;
import com.pethistory.pet.repositories.UsuarioRepo;
import com.pethistory.pet.repositories.UsuarioRolesRepo;
import com.pethistory.pet.repositories.VeterinariasRepositories;

import jakarta.persistence.EntityNotFoundException;



@Service
public class UsuarioRolesServImple implements UsuarioRolesServ {
    private final UsuarioRepo usuRepo;
    private final RolRepositorye rolRepo;
    private final VeterinariasRepositories vetRepo;
    private final UsuarioRolesRepo usuRolRepo;
    private final UsuarioRolesMapper usuRolMapper;

    public UsuarioRolesServImple ( UsuarioRepo usuRepo, RolRepositorye rolRepo,VeterinariasRepositories vetRepo,UsuarioRolesRepo usuRolRepo,UsuarioRolesMapper usuRolMapper){
        this.usuRepo=usuRepo;
        this.rolRepo=rolRepo;
        this.vetRepo=vetRepo;
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
            Usuario usu = usuRepo.findById(usuRolDto.getIdDocumento()).orElseThrow(()->new EntityNotFoundException("Error#1 : Usuario no encontrado"));
            Rol rol= rolRepo.findById(usuRolDto.getIdRol()).orElseThrow(()->new EntityNotFoundException("Error#2 : Rol no encontrado"));
            Veterinarias vet = vetRepo.findById(usuRolDto.getIdVeterinaria()).orElseThrow(()->new EntityNotFoundException("Error#3 : Veterinaria no encontrado"));
            respuesta.setDoc(usuRolDto.getIdDocumento());
            respuesta.setNombreUsu(usu.getNom());
            respuesta.setIdRol(usuRolDto.getIdRol());
            respuesta.setNomRol(rol.getNomRol());
            respuesta.setIdVet(usuRolDto.getIdVeterinaria());
            respuesta.setNomVet(vet.getNom());
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
