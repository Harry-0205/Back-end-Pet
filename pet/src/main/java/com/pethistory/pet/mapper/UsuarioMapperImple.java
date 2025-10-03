package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.models.Cuenta;
import com.pethistory.pet.models.TipoDoc;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.CuentaRepo;
import com.pethistory.pet.repositories.TipoDocRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UsuarioMapperImple implements UsuarioMapper{

    private final TipoDocRepo tipDocRepo;

    public UsuarioMapperImple( CuentaRepo cuentaRepo, TipoDocRepo tipDocRepo){
        this.tipDocRepo= tipDocRepo;
    }

    @Override
    public Usuario toUsuario (DtoUsuario dtoUsuario){
        if (dtoUsuario == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(dtoUsuario.getNumDoc());
        usuario.setNom(dtoUsuario.getNombre());
        usuario.setApe1(dtoUsuario.getApeUno());
        usuario.setApe2(dtoUsuario.getApeDos());
        usuario.setTel(dtoUsuario.getTelefono());
        usuario.setContrato(dtoUsuario.getNumContra());
        usuario.setDir(dtoUsuario.getDireccion());
        usuario.setFecNac(dtoUsuario.getFechaNac());

        TipoDoc tipoDoc = tipDocRepo.findById(dtoUsuario.getTipdoc()).orElseThrow(()-> new EntityNotFoundException("Tipo de documento no encontrado"));
        usuario.setTipoDoc(tipoDoc);
        Cuenta cuenta = new Cuenta();
        cuenta.setCorreo(dtoUsuario.getCorreo());
        cuenta.setContra(dtoUsuario.getPassw());
        usuario.setCuenta(cuenta);

        return usuario;
    }
    @Override
    public DtoUsuario toDtoUsuario(Usuario usuario){
        if (usuario == null) {
            return null;
        }
        return new DtoUsuario(
            usuario.getId(),
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
    @Override
    public DtoUsuarioGett toDtoUsuarioGett(Usuario usuario){
        if (usuario == null) {
            return null;
        }
        DtoUsuarioGett dtoUsuarioGett = new DtoUsuarioGett();
        dtoUsuarioGett.setNumDoc(usuario.getId());
        dtoUsuarioGett.setNombre(usuario.getNom());
        dtoUsuarioGett.setApeUno(usuario.getApe1());
        dtoUsuarioGett.setApeDos(usuario.getApe2());
        dtoUsuarioGett.setTelefono(usuario.getTel());
        dtoUsuarioGett.setCorreo(usuario.getCuenta().getCorreo());
        return dtoUsuarioGett;
    }
    
}
