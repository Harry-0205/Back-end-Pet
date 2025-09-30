package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProceAsignaDto {
private Long idProcedi;
private String procedi;
private Long idHisto;
private String nombreMas;
private Long usuDog;
private String nomDoc;
@NotNull
private String estado;
private String mensaje;
}
