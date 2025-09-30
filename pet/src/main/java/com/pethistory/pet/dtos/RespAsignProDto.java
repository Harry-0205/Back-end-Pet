package com.pethistory.pet.dtos;

import java.util.List;

import lombok.Data;

@Data
public class RespAsignProDto {
private int totalSolicitados;
private int totalAsignados;
private int totalCancelados;
private List<ProceAsignaDto>data;
}
