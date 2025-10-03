package com.pethistory.pet.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EsquemaVacunas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecVacu;
    private String dosis;

    @ManyToOne
    @JoinColumn(name = "Vacuna", foreignKey = @ForeignKey(name="FK_vacu"))
    private Vacunas vacunas;

    @ManyToOne
    @JoinColumn(name = "Mascota", foreignKey = @ForeignKey(name="FK_masc"))
    private Mascota mascota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Usuario", foreignKey = @ForeignKey(name = "FK_Usuario_esquema"))
    private Usuario usuario;
}
