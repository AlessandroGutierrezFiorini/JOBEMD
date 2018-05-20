package com.dao;

import com.pojo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by root on 31/12/16.
 */
@Transactional
@Repository
public class UsuarioDaoImpl  implements  UsuarioDao{

    @Autowired
    private SessionFactory sessionFactory;


    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Usuario> findAllUsers() {

        Query query = getSession().createQuery("from Usuario where estacionado = :estacionado");
        query.setParameter("estacionado",new Boolean(true));
        return query.list();
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        getSession().update(usuario);
    }


    @Override
    public Boolean dejarEstacionamientoUsuario(Usuario usuario) {
        Query query = getSession().createQuery("update Usuario set estacionado = :estaciono , estaciono = :horaNull WHERE id = :id");
        query.setParameter("estaciono",new Boolean(false));
        query.setParameter("horaNull",null);
        query.setParameter("id",usuario.getId());
        int result = query.executeUpdate();
        if(result >= 1){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public Double getSaldo(Usuario usuario) {
        Criteria criteria = getSession().createCriteria(Usuario.class)
                .add(Restrictions.like("username",usuario.getUsername()));
        Usuario usuarioEncontrado = (Usuario) criteria.uniqueResult();
        return Math.rint(usuarioEncontrado.getSaldo() * 100)/100;
    }

}
