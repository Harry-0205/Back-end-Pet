package com.pethistory.pet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class HistoriaClinicaDto {
    private Long idHist;
    private Long idpet;
    private Long idproce;
    private String anot;
}
