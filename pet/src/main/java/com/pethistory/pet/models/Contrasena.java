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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correo", referencedColumnName = "correo")
    private Usuario usuario;

    @Column(columnDefinition  = "VARBINARY(500)")
    private byte [] contra;
}
