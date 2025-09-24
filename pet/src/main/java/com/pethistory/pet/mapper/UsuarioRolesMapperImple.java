package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioAsignacionVet;
import com.pethistory.pet.dtos.UsuarioRolesDto;
import com.pethistory.pet.models.Rol;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.models.UsuarioRolId;
import com.pethistory.pet.models.UsuarioRoles;
import com.pethistory.pet.models.Veterinarias;
import com.pethistory.pet.repositories.RolRepositorye;
import com.pethistory.pet.repositories.UsuarioRepo;
import com.pethistory.pet.repositories.VeterinariasRepositories;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UsuarioRolesMapperImple implements UsuarioRolesMapper{

    private final UsuarioRepo usuRepo;
    private final RolRepositorye rolRepo;
    private final VeterinariasRepositories vetRepo;

    public UsuarioRolesMapperImple(UsuarioRepo usuRepo, RolRepositorye rolRepo,VeterinariasRepositories vetRepo){
        this.usuRepo=usuRepo;
        this.rolRepo=rolRepo;
        this.vetRepo=vetRepo;
    }
    @Override
    public UsuarioRoles toUsuarioRoles(UsuarioRolesDto usuRolDto){
        if ( usuRolDto == null) {
            return null;
        }
        Usuario usu = usuRepo.findById(usuRolDto.getIdDocumento()).orElseThrow(()-> new EntityNotFoundException("Documento no encontrado"));

        Rol rol = rolRepo.findById(usuRolDto.getIdRol()).orElseThrow(()->new EntityNotFoundException("Rol no encontrado"));

        UsuarioRolId id = new UsuarioRolId(usuRolDto.getIdDocumento(),usuRolDto.getIdRol());

        UsuarioRoles uR= new UsuarioRoles();
        uR.setId(id);
        uR.setUsuario(usu);
        usu.setNom(usuRolDto.getNomUsuario());
        uR.setRol(rol);
        usuRolDto.setNomRol(rol.getNomRol());
        Veterinarias vet= vetRepo.findById(usuRolDto.getIdVeterinaria()).orElseThrow(()->new EntityNotFoundException("Nit no encontrado"));
        uR.setVeterinarias(vet);
        vet.setNom(usuRolDto.getNomVeterinaria());
        return uR;
    }
    @Override
    public UsuarioRolesDto toUsuarioRolesDto(UsuarioRoles usuRol){
        return new UsuarioRolesDto(
            usuRol.getUsuario().getId(),
            usuRol.getUsuario().getNom(),
            usuRol.getRol().getId(),
            usuRol.getRol().getNomRol(),
            usuRol.getVeterinarias().getIdVet(),
            usuRol.getVeterinarias().getNom()
        );
    }
    @Override
    public DtoUsuarioAsignacionVet toAsignacion(UsuarioRoles entity){
        DtoUsuarioAsignacionVet dto = new DtoUsuarioAsignacionVet();
        dto.setDoc(entity.getUsuario().getId());
        dto.setNombreUsu(entity.getUsuario().getNom());
        dto.setNumContra(entity.getUsuario().getContrato());
        dto.setIdVet(entity.getVeterinarias().getIdVet());
        dto.setNomVet(entity.getVeterinarias().getNom());
        return dto;
    }
}
