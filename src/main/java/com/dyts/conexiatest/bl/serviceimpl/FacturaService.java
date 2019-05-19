/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * FacturaService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IFacturaService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.entities.Factura;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:20:19 a.m.
 */
@Service
public class FacturaService implements IFacturaService<Factura> {

    GenericDao<Factura> genericDao;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public Factura create(Factura factura) throws Exception {
        return (Factura) genericDao.create(factura);
    }

    @Override
    public void delete(Factura id) throws Exception {
        genericDao.delete(id);
    }

    @Override
    public Factura find(Factura id) throws Exception {
        return (Factura) genericDao.find(id);
    }

    @Override
    public Factura update(Factura factura) throws Exception {
        return (Factura) genericDao.update(factura);
    }

    @Override
    public Factura findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return (Factura) genericDao.findOneByNamedQuery(namedQuery, parameterName, value);
    }

    @Override
    public List<Factura> findAll() throws Exception {
        return genericDao.findAll(new Factura());
    }

    @Override
    public List<Factura> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Factura> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Factura> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
