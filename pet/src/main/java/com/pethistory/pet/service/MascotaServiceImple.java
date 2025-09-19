package com.pethistory.pet.service;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.dtos.DtoMascotaAll;
import com.pethistory.pet.dtos.MascotaUpdateDto;
import com.pethistory.pet.mapper.MascotaGettMapper;
import com.pethistory.pet.models.Mascota;
import com.pethistory.pet.repositories.MascotaRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class MascotaServiceImple implements MascotaService {

    private final MascotaRepo mascRepo;
    private final MascotaGettMapper mascMap;


    public MascotaServiceImple(MascotaRepo mascRepo, MascotaGettMapper mascMap){
    this.mascRepo= mascRepo;
    this.mascMap= mascMap;
    }

    @Override
    public DtoMascota crear(DtoMascota dtoMascota){
        Mascota mascota = mascMap.toMascota(dtoMascota);
        Mascota guardado = mascRepo.save(mascota);
        return mascMap.toDtoMascota(guardado);
    }
    @Override
    public DtoMascota buscarIdAll(Long id){
        return mascRepo.findById(id).map(mascMap::toDtoMascota).orElseThrow(()-> new EntityNotFoundException("Mascota no encontrada"));
    }

    @Override
    public DtoMascotaAll buscarId(Long id){
        return mascRepo.findById(id).map(mascMap::toDtoMascotaAll).orElseThrow(()-> new EntityNotFoundException("Mascota no encontrada"));
    }

    @Override
    @Transactional
    public DtoMascota actualizarMascota(MascotaUpdateDto dto) {
        Mascota mascota = mascRepo.findById(dto.getIdMasc())
        .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));


        mascota.setNombre(dto.getNom());
        mascota.setFecNam(dto.getFecNam());
        mascota.setFoto(dto.getFoto());

        Mascota actualizado = mascRepo.save(mascota);
        return mascMap.toDtoMascota(actualizado);
        
    }
}


