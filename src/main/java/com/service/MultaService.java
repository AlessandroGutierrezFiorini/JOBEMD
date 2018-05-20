package com.service;

import com.dao.MultaDao;
import com.pojo.Multa;
import com.pojo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alessandro on 08/02/17.
 */
@Service
public class MultaService {

    @Autowired
    private MultaDao multaDao;

    public void saveMulta(Multa multa){

        multaDao.saveMulta(multa);
    }

  }
