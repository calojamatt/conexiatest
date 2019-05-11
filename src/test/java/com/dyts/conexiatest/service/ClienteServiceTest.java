/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyts.conexiatest.service;

import com.dyts.conexiatest.entities.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CarlosMatt
 */
public class ClienteServiceTest {
    
    Cliente t;
    ClienteService service;
    
    public ClienteServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCreate() throws Exception {
        t = new Cliente();
        t.setNombre("Carlos Alberto");
        t.setApellido1("Maturana");
        t.setApellido2("Mulett");
        t.setObservaciones("prueba de dao y service");
        service = new ClienteService();
        
        System.out.println("create");
        Object expResult = null;
        Object result = service.create(t);
        assertNotEquals(expResult, result);
    }
    
}
