package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoEsquemaVacunas {
   
   @NotNull
   private Long id;
   
   @NotNull
   @Size(min = 3, max = 255)
   private String dos;

   @NotNull
   private Date fecVacu;

   @NotNull
   private Long idMascota;

   @NotNull
   private Long usuarioDoc;

   @NotNull Long idVacuna;


}
