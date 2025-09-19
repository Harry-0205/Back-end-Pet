package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.VeterinariasDto;
import com.pethistory.pet.models.Veterinarias;

public interface VeterinariaMapper {
    Veterinarias toVeterinarias(VeterinariasDto veterinariasDto);
    VeterinariasDto toVeterinariasDto( Veterinarias veterinarias);

}
