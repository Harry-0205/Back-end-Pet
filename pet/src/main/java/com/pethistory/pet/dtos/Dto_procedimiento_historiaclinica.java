package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dto_procedimiento_historiaclinica {
    @NotNull
    private Long idhisto;
    @NotNull
    private Long idProcedi;
    @NotNull
    private String anota;
    @NotNull
    private Long usuaDog;

    private String nombDoc;
}
