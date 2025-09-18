package com.pethistory.pet.service;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.VeterinariasDto;
import com.pethistory.pet.mapper.VeterinariaMapper;
import com.pethistory.pet.models.Veterinarias;
import com.pethistory.pet.repositories.VeterinariasRepositories;

@Service
public class VeterinariasServiceImple implements VeterinariasService{
private final VeterinariasRepositories veterep;
private final VeterinariaMapper vetemap;

public VeterinariasServiceImple(VeterinariasRepositories veterep, VeterinariaMapper vetemap){
    this.veterep;
    this.vetemap;
    
}
@Override
public VeterinariasDto crear(VeterinariasDto veterinariasDto){
    Veterinarias veterinarias=vetemap.toVeterinarias(veterinariasDto)
}

}

