/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * MesaService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IMesaService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.entities.Mesa;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:19:59 a.m.
 */
@Service
public class MesaService implements IMesaService<Mesa> {

    GenericDao<Mesa> genericDao;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public Mesa create(Mesa mesa) throws Exception {
        return (Mesa) genericDao.create(mesa);
    }

    @Override
    public void delete(Mesa id) throws Exception {
        genericDao.delete(id);
    }

    @Override
    public Mesa find(Mesa id) throws Exception {
        return (Mesa) genericDao.find(id);
    }

    @Override
    public Mesa update(Mesa mesa) throws Exception {
        return (Mesa) genericDao.update(mesa);
    }

    @Override
    public Mesa findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return (Mesa) genericDao.findOneByNamedQuery(namedQuery, parameterName, value);
    }

    @Override
    public List<Mesa> findAll() throws Exception {
        return genericDao.findAll(new Mesa());
    }

    @Override
    public List<Mesa> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Mesa> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Mesa> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
