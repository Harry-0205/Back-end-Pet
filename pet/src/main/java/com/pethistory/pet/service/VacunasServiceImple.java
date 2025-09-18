package com.pethistory.pet.service;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.VacunasDto;
import com.pethistory.pet.mapper.VacunasMapper;
import com.pethistory.pet.models.Vacunas;
import com.pethistory.pet.repositories.VacunasRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VacunasServiceImple implements VacunasService{

    private final VacunasRepo vacRepo;
    private final VacunasMapper vacMap;

    public VacunasServiceImple(VacunasRepo vacRepo, VacunasMapper vacMap){
        this.vacRepo = vacRepo;
        this.vacMap = vacMap;
    }
    @Override
    public VacunasDto crear(VacunasDto vacunasDto){
        Vacunas vacunas = vacMap.toVacunas(vacunasDto);
        Vacunas guardado = vacRepo.save(vacunas);
        return vacMap.toVacunasDto(guardado);
    }
    @Override
    public VacunasDto buscarIdAll(Long id){
        return vacRepo.findById(id).map(vacMap::toVacunasDto).orElseThrow(()-> new EntityNotFoundException("Vacuna no encontrada"));
    }

}
