package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Time;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcedimientoDto {

    private Long idProcedimiento;

    @NotNull
    @Size(max = 50)
    private String procedimiento;

    @NotNull
    private Integer costo;

    @NotNull
    private Time duracion;

    @NotNull
    @Size(max = 500)
    private String anotaciones;

}
