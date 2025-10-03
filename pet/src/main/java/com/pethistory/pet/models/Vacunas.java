package com.pethistory.pet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Vacunas{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String vacuna;
    private Long costo;
    private String dosis;
    @Column(length = 255)
    private String duracion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idEspecie", foreignKey = @ForeignKey(name = "FK_Id_Especie"))
    private Especie especie;
}