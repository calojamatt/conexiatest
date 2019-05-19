/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * CamareroService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.ICamareroService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.entities.Camarero;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:19:45 a.m.
 */
@Service
public class CamareroService implements ICamareroService<Camarero> {

    GenericDao<Camarero> genericDao;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public Camarero create(Camarero camarero) throws Exception {
        return (Camarero) genericDao.create(camarero);
    }

    @Override
    public void delete(Camarero id) throws Exception {
        genericDao.delete(id);
    }

    @Override
    public Camarero find(Camarero id) throws Exception {
        return (Camarero) genericDao.find(id);
    }

    @Override
    public Camarero update(Camarero camarero) throws Exception {
        return (Camarero) genericDao.update(camarero);
    }

    @Override
    public Camarero findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return (Camarero) genericDao.findOneByNamedQuery(namedQuery, parameterName, value);
    }

    @Override
    public List<Camarero> findAll() throws Exception {
        return genericDao.findAll(new Camarero());
    }

    @Override
    public List<Camarero> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Camarero> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Camarero> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
