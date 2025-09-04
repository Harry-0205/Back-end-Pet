package com.pethistory.pet.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;



@Entity
@Data
@Table(name =  "Raza")
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRaza;
    
    @Column(name = "nomRaza" , length = 11)
    private String Raza;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especie" , foreignKey =  @ForeignKey(name = "FK_Id_Especie"))
    private Especie especie;
}
