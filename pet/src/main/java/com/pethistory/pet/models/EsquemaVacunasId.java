package com.pethistory.pet.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class EsquemaVacunasId implements Serializable {
    private long idMascota;
    private long idVacuna;


}
