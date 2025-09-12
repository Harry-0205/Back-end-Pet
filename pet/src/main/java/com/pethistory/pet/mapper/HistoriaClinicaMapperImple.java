package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.models.HistoriaClinica;
import com.pethistory.pet.repositories.HistoriaClinicaRepositories;
import com.pethistory.pet.repositories.MascotaRepo;

@Component
public class HistoriaClinicaMapperImple {
    private final HistoriaClinicaRepositories hisclirep;
    private final MascotaRepo masrep;

    public HistoriaClinicaMapperImple(
        HistoriaClinicaRepositories hisclirep,
        MascotaRepo masrep){
            this.masrep=masrep;
            this.hisclirep=hisclirep;
        }

    

}
