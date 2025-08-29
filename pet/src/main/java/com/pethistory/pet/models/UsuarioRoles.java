package com.pethistory.pet.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioRoles {
    @Embeddable
    public class UsuarioRolId implements Serializable {
        private Long usuarioDoc;
        private Long idRol;
    }
    @EmbeddedId
    private UsuarioRolId  id = new UsuarioRolId();

    @ManyToOne
    @MapsId("usuarioDoc")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idRol")
    private Rol rol;

    @ManyToOne(optional = false)
    @JoinColumn(name = "veterinariasIdVet", foreignKey = @ForeignKey(name="FK_idVet"))
    private Veterinarias veterinarias;



}
