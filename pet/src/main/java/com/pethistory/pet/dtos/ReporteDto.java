package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReporteDto {
    
    private Long idRepor;
    @NotNull
    private Long idHisto;
    @NotNull
    private Long idProcedi;
    
    private String anota;
    @NotNull
    private Long usuaDog;

    private String nombDoc;
}
