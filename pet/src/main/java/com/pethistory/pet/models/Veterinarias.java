package com.pethistory.pet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Veterinarias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVet;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false, length = 100)
    private String correo;
    @Column(nullable = false, length = 255)
    private String foto;
    @Column(nullable = false, length = 100)
    private String direc;


}
