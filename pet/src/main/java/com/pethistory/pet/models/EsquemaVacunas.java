package com.pethistory.pet.models;

import java.io.Serializable;
import java.sql.Date;


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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EsquemaVacunas {
    private Date fecVacu;
    @Embeddable
    public class EsquemaVacunasId implements Serializable {
        private Long idMascota;
        private Long idVacuna;
    }
    @EmbeddedId
    private EsquemaVacunasId id = new EsquemaVacunasId();

    @ManyToOne
    @MapsId("idVacuna")
    private Vacunas vacunas;

    @ManyToOne
    @MapsId("idMascota")
    private Mascota mascota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Usuario", foreignKey = @ForeignKey(name = "FK_UsuarioDoc"))
    private Usuario usuario;


}
