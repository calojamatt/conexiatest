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

package com.dyts.conexiatest.service;

import com.dyts.conexiatest.dao.GenericDao;
import com.dyts.conexiatest.entities.Mesa;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:19:59 a.m.
 */
public class MesaService extends GenericDao<Mesa>{

    GenericDao<Mesa> daoClass;

    public MesaService() {
        daoClass = new GenericDao<Mesa>() { };
    }

}
