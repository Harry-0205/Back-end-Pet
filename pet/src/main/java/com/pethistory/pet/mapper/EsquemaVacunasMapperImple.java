package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.DtoEsquemaVacunas;
import com.pethistory.pet.dtos.EsquemaVacunasCreateDto;
import com.pethistory.pet.models.EsquemaVacunas;
import com.pethistory.pet.models.Mascota;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.models.Vacunas;
import com.pethistory.pet.repositories.MascotaRepo;
import com.pethistory.pet.repositories.UsuarioRepo;
import com.pethistory.pet.repositories.VacunasRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class EsquemaVacunasMapperImple implements EsquemaVacunasMapper{

    private final MascotaRepo mascotaRepo;
    private final VacunasRepo vacunasRepo;
    private final UsuarioRepo usuarioRepo;

    public EsquemaVacunasMapperImple(MascotaRepo mascotaRepo, VacunasRepo vacunasRepo, UsuarioRepo usuarioRepo){
        this.mascotaRepo = mascotaRepo;
        this.vacunasRepo = vacunasRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public EsquemaVacunas toEsquema(EsquemaVacunasCreateDto dto){
        if (dto == null) return null;
        Mascota masc = mascotaRepo.findById(dto.getIdMascota())
            .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
        Vacunas vac = vacunasRepo.findById(dto.getIdVacuna())
            .orElseThrow(() -> new EntityNotFoundException("Vacuna no encontrada"));
        Usuario usu = usuarioRepo.findById(dto.getUsuarioDoc())
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        EsquemaVacunas entity = new EsquemaVacunas();
        entity.setFecVacu(dto.getFecVacu());
        entity.setDosis(dto.getDos());
        entity.setMascota(masc);
        entity.setVacunas(vac);
        entity.setUsuario(usu);
        return entity;
    }

    @Override
    public DtoEsquemaVacunas toDto(EsquemaVacunas entity){
        if (entity == null) return null;
        DtoEsquemaVacunas dto = new DtoEsquemaVacunas();
        dto.setDos(entity.getDosis());
        dto.setFecVacu(entity.getFecVacu());
        dto.setIdMascota(entity.getMascota().getId());
        dto.setIdVacuna(entity.getVacunas().getId());
        dto.setUsuarioDoc(entity.getUsuario().getId());
        return dto;
    }

    @Override
    public void updateEntity(EsquemaVacunas entity, DtoEsquemaVacunas dto){
        if (entity == null || dto == null) return;
        entity.setDosis(dto.getDos());
        entity.setFecVacu(dto.getFecVacu());
        
        if (dto.getUsuarioDoc() != null && !dto.getUsuarioDoc().equals(entity.getUsuario().getId())){
            Usuario usu = usuarioRepo.findById(dto.getUsuarioDoc())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
            entity.setUsuario(usu);
        }
    }
}
