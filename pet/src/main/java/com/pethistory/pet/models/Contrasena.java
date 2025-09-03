package com.pethistory.pet.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contrasena {
    @Id
    private String correo;

    @Column(columnDefinition  = "VARBINARY(500)")
    private byte [] contra;

    @OneToOne(mappedBy = "contrasena")
    private Usuario usuario;
}
