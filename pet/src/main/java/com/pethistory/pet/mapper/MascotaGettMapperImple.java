package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.models.Color;
import com.pethistory.pet.models.Mascota;
import com.pethistory.pet.models.Raza;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.ColorRepositorio;
import com.pethistory.pet.repositories.RazaRepo;
import com.pethistory.pet.repositories.UsuarioRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class MascotaGettMapperImple implements MascotaGettMapper{

private final ColorRepositorio colorRepo;
private final UsuarioRepo usuarioDoc;
private final RazaRepo razaRepo;

public MascotaGettMapperImple(ColorRepositorio colorRepo, UsuarioRepo usuarioDoc, RazaRepo razaRepo){
    this.colorRepo= colorRepo;
    this.usuarioDoc= usuarioDoc;
    this.razaRepo= razaRepo;
}
@Override
public Mascota toMascota(DtoMascota dtoMascota){
    if (dtoMascota == null){
    return null;
    }
    Mascota mascota = new Mascota();
    mascota.setIdMascota(dtoMascota.getIdMasc());
    mascota.setNombre(dtoMascota.getNom());
    mascota.setFecNam(dtoMascota.getFecNam());
    mascota.setFoto(dtoMascota.getFoto());

    Color col = colorRepo.findById(dtoMascota.getIdColor()).orElseThrow(()-> new EntityNotFoundException("Esta id no pertenece a ningun color"));
    mascota.setColor(col);
    
    Usuario usu =  usuarioDoc.findById(dtoMascota.getUsuarioDoc()).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    mascota.setUsuario(usu);

    Raza raza = razaRepo.findById(dtoMascota.getIdRaza()).orElseThrow(()-> new EntityNotFoundException("Esta id no pertenece a ninguna raza"));
    mascota.setRaza(raza);

    return mascota;
    }
    @Override
    public DtoMascota toDtoMascota (Mascota mascota){
        if(mascota == null) {
            return null;
        }
        return new DtoMascota(
            mascota.getIdMascota(),
            mascota.getNombre(),
            mascota.getFecNam(),
            mascota.getFoto(),
            mascota.getColor().getIdColor(),
            mascota.getColor().getNomColor(),
            mascota.getUsuario().getDoc(),
            mascota.getUsuario().getNom(),
            mascota.getRaza().getIdRaza(),
            mascota.getRaza().getRaza()
        );

    }
}
