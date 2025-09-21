package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.HistoriaClinicaDto;
import com.pethistory.pet.mapper.HistoriaClinicaMapper;
import com.pethistory.pet.models.HistoriaClinica;
import com.pethistory.pet.models.Mascota;
import com.pethistory.pet.repositories.HistoriaClinicaRepositories;
import com.pethistory.pet.repositories.MascotaRepo;

import jakarta.persistence.EntityNotFoundException;
@Service
public class HistoriaclinicaServiceImplement implements HistoriaclinicaService{
    private final HistoriaClinicaRepositories hiclirep;
    private final HistoriaClinicaMapper hiclimapp;
    private final MascotaRepo masrep;

    public HistoriaclinicaServiceImplement(HistoriaClinicaRepositories hiclirep, HistoriaClinicaMapper hisclimapp, MascotaRepo masrep){
        this.hiclirep=hiclirep;
        this.hiclimapp=hisclimapp;
        this.masrep=masrep;
    }
    @Override
    public HistoriaClinicaDto crear (HistoriaClinicaDto historiaClinicaDto){
        HistoriaClinica historiaClinica=hiclimapp.tHistoriaClinica(historiaClinicaDto);
        HistoriaClinica savee = hiclirep.save(historiaClinica);
        return hiclimapp.toHistoriaClinicaDto(savee);
    }
    @Override
    public HistoriaClinicaDto buscarId(Long id){
        return hiclirep.findById(id).map(hiclimapp::toHistoriaClinicaDto).orElseThrow(()->new EntityNotFoundException("historia no encontrada"));
    }
    @Override
    public List<HistoriaClinicaDto> todaslasHis(){
        return hiclirep.findAll().stream().map(hiclimapp::toHistoriaClinicaDto).collect(Collectors.toList());
    }
    @Override
    public HistoriaClinicaDto actualizar(HistoriaClinicaDto historiaClinicaDto){
        HistoriaClinica historiaClinica=hiclirep.findById(historiaClinicaDto.getId())
        .orElseThrow(()-> new EntityNotFoundException("Historia no escontrada"));

        historiaClinica.setAnotaciones(historiaClinicaDto.getAnot());
        historiaClinica.setFechaIni(historiaClinicaDto.getFechaI());

        Mascota masc = masrep.findById(historiaClinicaDto.getIdMascta())
        .orElseThrow(()-> new EntityNotFoundException("Mascota no encontrada"));
        masc.setNombre(historiaClinicaDto.getNombreMascot());

        HistoriaClinica actualizada = hiclirep.save(historiaClinica);
        return hiclimapp.toHistoriaClinicaDto(actualizada);
    }
}
