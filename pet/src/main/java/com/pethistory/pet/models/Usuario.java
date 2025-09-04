package com.pethistory.pet.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doc;
    private String nom;
    private String ape1;
    private String ape2;
    private Long tel;
    private Long contrato;
    private String dir;
    private Date fecNac;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idTipo", foreignKey = @ForeignKey(name = "FK_Usuario_1"))
    private TipoDoc tipoDoc;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRoles> roles;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correo", referencedColumnName = "correo",foreignKey = @ForeignKey(name = "FK_Correo"))
    private Contrasena contrasena;
}
