package com.dao;

import com.pojo.Multa;
import com.pojo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alessandro on 08/02/17.
 */
@Transactional
@Repository
public class MultaDaoImpl implements MultaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveMulta(Multa multa) {
        getSession().save(multa);
    }


//        Criteria criteria = getSession().createCriteria(Multa.class)
//                .add(Restrictions.like("id_usuario",new Integer(usuario.getId().intValue())));
//        return criteria.list();

}
