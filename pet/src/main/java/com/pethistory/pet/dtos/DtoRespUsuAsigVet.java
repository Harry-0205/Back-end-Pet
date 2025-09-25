package com.pethistory.pet.dtos;

import java.util.List;

import lombok.Data;

@Data
public class DtoRespUsuAsigVet {
    private int totalSolicitudes;
    private int totalAsignaciones;
    private int totalDuplicadas;
    private int totalFallidas;
    private List<DtoUsuarioAsignacionVet> detalles;
}
