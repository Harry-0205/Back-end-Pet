package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.VeterinariasDto;

public interface VeterinariasService {
    VeterinariasDto crear(VeterinariasDto veterinariasDto);
    VeterinariasDto niit(Long id);
    VeterinariasDto cambiar(VeterinariasDto veterinariasDto);
    List<VeterinariasDto> listar();

}
