package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TipoDocDto {
    @NotNull
    private Long idTipo;
    private String tipoDoc;
}


