package com.pethistory.pet.models;

import java.io.Serializable;


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
    @EmbeddedId
    private UsuarioRolId  id = new UsuarioRolId();

    @ManyToOne
    @MapsId("idDoc")
    @JoinColumn(name = "docUsuario",foreignKey = @ForeignKey(name="FK_usuario_doc"))
    private Usuario usuario;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "idRol",foreignKey = @ForeignKey(name="FK_id_rol"))
    private Rol rol;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idVet", foreignKey = @ForeignKey(name="FK_idVet"))
    private Veterinarias veterinarias;



}
