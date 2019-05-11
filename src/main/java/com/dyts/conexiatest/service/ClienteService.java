/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * ClienteService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.service;

import com.dyts.conexiatest.dao.GenericDao;
import com.dyts.conexiatest.entities.Cliente;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:08:18 a.m.
 */
public class ClienteService extends GenericDao<Cliente>{

    GenericDao<Cliente> daoClass;

    public ClienteService() {
        daoClass = new GenericDao<Cliente>() { };
    }
    
}
