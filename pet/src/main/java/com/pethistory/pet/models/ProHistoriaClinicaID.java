package com.pethistory.pet.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"idHistoria","idProcedimiento"})
public class ProHistoriaClinicaID implements Serializable{
    public ProHistoriaClinicaID( Long id1, Integer id2){
    }
    private Integer idHistoria;
    private Long idProcedimiento;

}