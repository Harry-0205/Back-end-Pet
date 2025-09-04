package com.pethistory.pet.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
    @Embeddable
    public class ProHistoriaClinicaID implements Serializable{
        private Long idHistoria;
        private Long idProcedimiento;
    }

    @EmbeddedId
    private ProHistoriaClinicaID  id = new ProHistoriaClinicaID();

    @ManyToOne
    @MapsId("idHistoria")
    private HistoriaClinica historiaClinica;

    @ManyToOne
    @MapsId("idProcedimiento")
    private Procedimiento procedimiento;
    

}
