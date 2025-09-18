package com.pethistory.pet.models;


import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaIni;
    private String anotaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="mascota_id", referencedColumnName ="id", foreignKey = @ForeignKey(name= "FK_historiaclinica_mascota"))
    private Mascota mascota;
    

    
}



