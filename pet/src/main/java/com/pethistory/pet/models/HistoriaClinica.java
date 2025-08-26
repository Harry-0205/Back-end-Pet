package com.pethistory.pet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HistoriaClinica {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idHistoria;
private Long idMascota;
private Long idProcedimiento;
@Column(nullable = false, length = 20)
private String anotaciones;
}
