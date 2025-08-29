package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.pethistory.pet.models.Estado;
import com.pethistory.pet.models.Procedimiento;
import com.pethistory.pet.models.Veterinarias;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamientoDto {

    @NotNull
    private Long idCita;

    @NotNull
    private Timestamp fecAg;

    @NotNull
    private Date fecAsi;

    @NotNull
    private List<Procedimiento> procedimientos;

    @NotNull
    private List<Veterinarias> veterinarias;

    @NotNull
    private List<Estado> estados;
}
