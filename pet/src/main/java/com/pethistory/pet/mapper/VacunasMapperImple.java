package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.VacunasDto;
import com.pethistory.pet.models.Especie;
import com.pethistory.pet.models.Vacunas;
import com.pethistory.pet.repositories.EspecieRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Component
public class VacunasMapperImple implements VacunasMapper {
    
    private final EspecieRepositorio especieRepo;

    public VacunasMapperImple(EspecieRepositorio especieRepo) {
        this.especieRepo = especieRepo;
    }

    @Override
    public Vacunas toVacunas(VacunasDto vacunasDto) {
        if (vacunasDto == null) {
            return null;    

        }
        Vacunas vacunas = new Vacunas();
        vacunas.setId(vacunasDto.getIdVacuna());
        vacunas.setVacuna(vacunasDto.getVacuna());
        vacunas.setCosto(vacunasDto.getCosto());    
        vacunas.setDosis(vacunasDto.getDosis());
        vacunas.setDuracion(vacunasDto.getDuracion());

        Especie especie = especieRepo.findById(vacunasDto.getIdEspecie()).orElseThrow(()-> new EntityNotFoundException("Especie no encontrada"));
        vacunas.setEspecie(especie);
        return vacunas;
    }
    @Override
    public VacunasDto toVacunasDto(Vacunas vacunas) {
        if (vacunas == null) {
            return null;
        }
        return new VacunasDto(
            vacunas.getId(),
            vacunas.getVacuna(),
            vacunas.getCosto(),
            vacunas.getDosis(),
            vacunas.getDuracion(),
            vacunas.getEspecie().getId(),
            vacunas.getEspecie().());
    }
}