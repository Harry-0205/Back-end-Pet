package com.pethistory.pet.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doc;
    @Column(length = 20)
    private String nom;
    @Column(length = 20)
    private String ape1;
    @Column(length = 20)
    private String ape2;
    @Column(length = 20)
    private String tel;
    private Integer contrato;
    @Column(length = 50)
    private String direc;
    @Column(length = 100)
    private String correo;
    @Column(columnDefinition = "VARBINARY(500)")
    private byte [] contraseña;
    private Date fecNac;
}
