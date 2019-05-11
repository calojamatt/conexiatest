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

package com.dyts.conexiatest.service;

import com.dyts.conexiatest.dao.GenericDao;
import com.dyts.conexiatest.entities.Detallefactura;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:20:29 a.m.
 */
public class DetallefacturaService extends GenericDao<Detallefactura>{

    GenericDao<Detallefactura> daoClass;

    public DetallefacturaService() {
        daoClass = new GenericDao<Detallefactura>() { };
    }

}
