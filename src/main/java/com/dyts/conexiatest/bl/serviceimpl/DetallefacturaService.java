/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * DetallefacturaService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IDetallefacturaService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.entities.Detallefactura;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:20:29 a.m.
 */
@Service
public class DetallefacturaService implements IDetallefacturaService<Detallefactura> {

    GenericDao<Detallefactura> genericDao;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public Detallefactura create(Detallefactura detallefactura) throws Exception {
        return null;
    }

    @Override
    public void delete(Detallefactura id) throws Exception {

    }

    @Override
    public Detallefactura find(Detallefactura id) throws Exception {
        return null;
    }

    @Override
    public Detallefactura update(Detallefactura detallefactura) throws Exception {
        return null;
    }

    @Override
    public Detallefactura findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return null;
    }

    @Override
    public List<Detallefactura> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Detallefactura> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Detallefactura> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Detallefactura> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
