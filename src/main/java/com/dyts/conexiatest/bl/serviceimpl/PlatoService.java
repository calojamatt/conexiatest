/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * PlatoService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IPlatoService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.entities.Plato;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:20:12 a.m.
 */
@Service
public class PlatoService implements IPlatoService<Plato> {

    GenericDao<Plato> genericDao;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public Plato create(Plato plato) throws Exception {
        return (Plato) genericDao.create(plato);
    }

    @Override
    public void delete(Plato id) throws Exception {
        genericDao.delete(id);
    }

    @Override
    public Plato find(Plato id) throws Exception {
        return (Plato) genericDao.find(id);
    }

    @Override
    public Plato update(Plato plato) throws Exception {
        return (Plato) genericDao.update(plato);
    }

    @Override
    public Plato findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return (Plato) genericDao.findOneByNamedQuery(namedQuery, parameterName, value);
    }

    @Override
    public List<Plato> findAll() throws Exception {
        return genericDao.findAll(new Plato());
    }

    @Override
    public List<Plato> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Plato> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Plato> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
