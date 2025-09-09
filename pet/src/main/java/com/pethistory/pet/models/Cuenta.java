package com.pethistory.pet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cuenta {
    @Id
    private String correo;

    @Column(columnDefinition  = "VARBINARY(500)")
    private byte [] contra;

    @OneToOne(mappedBy = "cuenta")
    private Usuario usuario;
}
