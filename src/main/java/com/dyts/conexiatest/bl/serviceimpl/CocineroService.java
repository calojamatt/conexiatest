/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * CocineroService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.ICocineroService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.entities.Cocinero;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:19:12 a.m.
 */
@Service
public class CocineroService  implements ICocineroService<Cocinero> {

    GenericDao<Cocinero> genericDao;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public Cocinero create(Cocinero cocinero) throws Exception {
        return (Cocinero) genericDao.create(cocinero);
    }

    @Override
    public void delete(Cocinero id) throws Exception {
        genericDao.delete(id);
    }

    @Override
    public Cocinero find(Cocinero id) throws Exception {
        return (Cocinero) genericDao.find(id);
    }

    @Override
    public Cocinero update(Cocinero cocinero) throws Exception {
        return (Cocinero) genericDao.update(cocinero);
    }

    @Override
    public Cocinero findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return (Cocinero) genericDao.findOneByNamedQuery(namedQuery, parameterName, value);
    }

    @Override
    public List<Cocinero> findAll() throws Exception {
        return genericDao.findAll(new Cocinero());
    }

    @Override
    public List<Cocinero> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Cocinero> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Cocinero> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
