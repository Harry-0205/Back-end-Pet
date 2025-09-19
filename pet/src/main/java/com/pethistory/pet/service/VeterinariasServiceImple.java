package com.pethistory.pet.service;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.VeterinariasDto;
import com.pethistory.pet.mapper.VeterinariaMapper;
import com.pethistory.pet.models.Veterinarias;
import com.pethistory.pet.repositories.VeterinariasRepositories;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VeterinariasServiceImple implements VeterinariasService{
private final VeterinariasRepositories veterep;
private final VeterinariaMapper vetemap;

public VeterinariasServiceImple(VeterinariasRepositories veterep, VeterinariaMapper vetemap){
    this.veterep=veterep;
    this.vetemap=vetemap;
    
}
@Override
public VeterinariasDto crear(VeterinariasDto veterinariasDto){
    Veterinarias veterinarias=vetemap.toVeterinarias(veterinariasDto);
    Veterinarias guardar = veterep.save(veterinarias);
    return vetemap.toVeterinariasDto(guardar);
}
@Override
public VeterinariasDto niit(Long id){
    return veterep.findById(id).map(vetemap::toVeterinariasDto).orElseThrow(()->new EntityNotFoundException("veterinaria no encotrada"));

}
@Override
public VeterinariasDto cambiar(VeterinariasDto veterinariasDto){
    Veterinarias veterinarias=veterep.findById(veterinariasDto.getIdVeterinaria())
    .orElseThrow(()-> new EntityNotFoundException("Veterinaria no fue posible acrualizar"));
    
    Veterinarias actualizada=veterep.save(veterinarias);
    return vetemap.toVeterinariasDto((actualizada));
}

}

