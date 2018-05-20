package com.service;

import com.dao.UsuarioDao;
import com.pojo.Usuario;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 31/12/16.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;



    public void updateUsuario(Usuario usuario){
        usuarioDao.updateUsuario(usuario);
    }

    public List<Usuario> findAllUsers(){
       return usuarioDao.findAllUsers();
    }


    public Boolean dejarEstacionamientoUsuario(Usuario usuario){
        return usuarioDao.dejarEstacionamientoUsuario(usuario);
    }


    public Double getSaldo(Usuario usuario) {
        return usuarioDao.getSaldo(usuario);
    }
}
