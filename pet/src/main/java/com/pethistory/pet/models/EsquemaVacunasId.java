package com.pethistory.pet.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class EsquemaVacunasId implements Serializable {
    public EsquemaVacunasId(Integer id, Integer id2){

    }

    private long idMascota;
    private long idVacuna;


}
