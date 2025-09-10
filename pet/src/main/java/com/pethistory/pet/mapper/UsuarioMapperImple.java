package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.models.Cuenta;
import com.pethistory.pet.models.TipoDoc;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.CuentaRepo;
import com.pethistory.pet.repositories.TipoDocRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UsuarioMapperImple implements UsuarioMapper{

    private final TipoDocRepo tipDocRepo;
    private final CuentaRepo cuentaRepo;

    public UsuarioMapperImple( CuentaRepo cuentaRepo, TipoDocRepo tipDocRepo){
        this.cuentaRepo= cuentaRepo;
        this.tipDocRepo= tipDocRepo;
    }

    @Override
    public Usuario toUsuario (DtoUsuario dtoUsuario){
        if (dtoUsuario == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setDoc(dtoUsuario.getNumDoc());
        usuario.setNom(dtoUsuario.getNombre());
        usuario.setApe1(dtoUsuario.getApeUno());
        usuario.setApe2(dtoUsuario.getApeDos());
        usuario.setTel(dtoUsuario.getTelefono());
        usuario.setContrato(dtoUsuario.getNumContra());
        usuario.setDir(dtoUsuario.getDireccion());
        usuario.setFecNac(dtoUsuario.getFechaNac());

        TipoDoc tipoDoc = tipDocRepo.findById(dtoUsuario.getTipdoc()).orElseThrow(()-> new EntityNotFoundException("Tipo de documento no encontrado"));
        usuario.setTipoDoc(tipoDoc);

        Cuenta cuenta = cuentaRepo.findById(dtoUsuario.getCorreo()).orElseThrow(()-> new EntityNotFoundException("Correo electronico no encontrado"));
        usuario.setCuenta(cuenta);
        cuenta.setContra(dtoUsuario.getPassw());

        return usuario;
    }
    @Override
    public DtoUsuario toDtoUsuario(Usuario usuario){
        if (usuario == null) {
            return null;
        }
        return new DtoUsuario(
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
            usuario.getCuenta().getCorreo(),
            usuario.getCuenta().getContra());
    }

    
}
