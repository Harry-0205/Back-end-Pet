package com.pethistory.pet.service;

import com.pethistory.pet.dtos.VeterinariasDto;

public interface VeterinariasService {
    VeterinariasDto crear(VeterinariasDto veterinariasDto);
    VeterinariasDto niit(VeterinariasDto veterinariasDto);
    VeterinariasDto Cambiar(VeterinariasDto veterinariasDto);

}
