package com.pethistory.pet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Getter
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @NotNull
    private Boolean realizado;
    @NotNull
    private Boolean cancelado;

}
