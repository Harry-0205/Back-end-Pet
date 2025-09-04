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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ProcedimientoHistoriaclinica {

    @EmbeddedId
    private ProHistoriaClinicaID  id = new ProHistoriaClinicaID();

    @ManyToOne
    @MapsId("idHistoria")
    @JoinColumn(name = "historia_id", foreignKey = @ForeignKey(name="FK_historia_proc"))
    private HistoriaClinica historiaClinica;

    @ManyToOne
    @MapsId("idProcedimiento")
    @JoinColumn(name = "procedimiento_id", foreignKey = @ForeignKey(name="FK_procedimiento_historia"))
    private Procedimiento procedimiento;
}
