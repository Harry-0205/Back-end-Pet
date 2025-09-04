package com.pethistory.pet.models;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMascota;
    private String nombre;
    private Date fecNam;
    private String foto;


    @ManyToOne(optional = false)
    @JoinColumn(name = "color", foreignKey = @ForeignKey(name = "FK_id_Color"))
    private Color color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Usuario", foreignKey = @ForeignKey(name = "FK_Usuario_3"))
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raza", foreignKey =  @ForeignKey(name = "FK_id_Raza"))
    private Raza raza;
    
    @OneToOne(mappedBy = "mascota")
    private HistoriaClinica historiaClinica;



}
