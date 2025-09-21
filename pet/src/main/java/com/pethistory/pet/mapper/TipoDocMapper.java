package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.TipoDocDto;
import com.pethistory.pet.models.TipoDoc;

public interface TipoDocMapper {
    TipoDocDto toTipoDocDto(TipoDoc tipoDoc);

}
