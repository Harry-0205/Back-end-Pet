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
   private Long idEsque;

   @NotNull
   @Size(min = 3, max = 255)
   private String dos;

   @NotNull
   private Date fecVacu;
}
