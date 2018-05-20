package com.dao;

import com.pojo.Usuario;

import java.util.List;

/**
 * Created by root on 31/12/16.
 */
public interface UsuarioDao {

        public void updateUsuario(Usuario usuario);

        Boolean dejarEstacionamientoUsuario(Usuario usuario);

        Double getSaldo(Usuario usuario);

        List<Usuario> findAllUsers();

}
