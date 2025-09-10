package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.models.Cuenta;
import com.pethistory.pet.models.TipoDoc;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.CuentaRepo;
import com.pethistory.pet.repositories.TipoDocRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UsuarioGettMapperImple implements UsuarioGettMapper {

    private final TipoDocRepo tipDocRepo;
    private final CuentaRepo cuentaRepo;

    public UsuarioGettMapperImple( CuentaRepo cuentaRepo, TipoDocRepo tipDocRepo){
        this.cuentaRepo= cuentaRepo;
        this.tipDocRepo= tipDocRepo;
    }
    @Override
    public Usuario toUsuario (DtoUsuarioGett dtoUsuariogGett){
        if (dtoUsuariogGett == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setDoc(dtoUsuariogGett.getNumDoc());
        usuario.setNom(dtoUsuariogGett.getNombre());
        usuario.setApe1(dtoUsuariogGett.getApeUno());
        usuario.setApe2(dtoUsuariogGett.getApeDos());
        usuario.setTel(dtoUsuariogGett.getTelefono());
        usuario.setContrato(dtoUsuariogGett.getNumContra());
        usuario.setDir(dtoUsuariogGett.getDireccion());
        usuario.setFecNac(dtoUsuariogGett.getFechaNac());

        TipoDoc tipoDoc = tipDocRepo.findById(dtoUsuariogGett.getTipdoc()).orElseThrow(()-> new EntityNotFoundException("Tipo de documento no encontrado"));
        usuario.setTipoDoc(tipoDoc);

        Cuenta cuenta = cuentaRepo.findById(dtoUsuariogGett.getCorreo()).orElseThrow(()-> new EntityNotFoundException("Correo electronico no encontrado"));
        usuario.setCuenta(cuenta);
        return usuario;
    }
    @Override
    public DtoUsuarioGett toDtoUsuarioGett(Usuario usuario){
        if (usuario == null) {
            return null;
        }
        return new DtoUsuarioGett(
            usuario.getDoc(),
            usuario.getNom(),
            usuario.getApe1(),
            usuario.getApe2(),
            usuario.getTel(),
            usuario.getContrato(),
            usuario.getDir(),
            usuario.getFecNac(),
            usuario.getTipoDoc().getIdTipo(),
            usuario.getTipoDoc().getTipoDoc(),
            usuario.getCuenta().getCorreo());
    }
}
