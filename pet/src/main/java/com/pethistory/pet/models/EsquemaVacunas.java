package com.pethistory.pet.models;

import java.sql.Date;

import jakarta.persistence.Column;
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
    private Long idEsquema;
    private Date fecVacu;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vacunas", foreignKey = @ForeignKey(name = "FK_Id_Vacuna"))
    private Vacunas vacunas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Mascota", foreignKey = @ForeignKey(name = "FK_id_Mascota"))
    private Mascota mascota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Usuario", foreignKey = @ForeignKey(name = "FK_UsuarioDoc"))
    private Usuario usuario;

    









}
